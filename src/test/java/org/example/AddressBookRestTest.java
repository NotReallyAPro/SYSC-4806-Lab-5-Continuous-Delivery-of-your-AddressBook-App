package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
public class AddressBookRestTest {

    @Autowired
    private RestTestClient restTestClient;

    @Test
    void createAddressBook() {
        restTestClient.post()
                .uri("/addressBooks")
                .contentType(MediaType.APPLICATION_JSON)
                .body("{}")
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @Test
    void createBuddyInfo() {
        String buddyJson = """
            {
                "name": "Homer",
                "address": "742 Evergreen Terrace",
                "phoneNumber": "(939) 555-0113"
            }
            """;

        restTestClient.post()
                .uri("/buddyInfoes")
                .contentType(MediaType.APPLICATION_JSON)
                .body(buddyJson)
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @Test
    void getBuddyFromAddressBook() {
        // Create an AddressBook
        var addressBookResult = restTestClient.post()
                .uri("/addressBooks")
                .contentType(MediaType.APPLICATION_JSON)
                .body("{}")
                .exchange()
                .expectStatus()
                .isCreated()
                .returnResult(String.class);

        String addressBookUrl = addressBookResult
                .getResponseHeaders()
                .getLocation()
                .toString();

        // Create a BuddyInfo
        String buddyJson = """
                {
                    "name": "Homer",
                    "address": "742 Evergreen Terrace",
                    "phoneNumber": "(939) 555-0113"
                }
                """;

        var buddyResult = restTestClient.post()
                .uri("/buddyInfoes")
                .contentType(MediaType.APPLICATION_JSON)
                .body(buddyJson)
                .exchange()
                .expectStatus()
                .isCreated()
                .returnResult(String.class);

        String buddyUrl = buddyResult
                .getResponseHeaders()
                .getLocation()
                .toString();

        // Add the BuddyInfo to the AddressBook
        restTestClient.post()
                .uri(addressBookUrl + "/buddies")
                .contentType(MediaType.parseMediaType("text/uri-list"))
                .body(buddyUrl)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

        // Retrieve the buddies and verify the response
        restTestClient.get()
                .uri(addressBookUrl + "/buddies")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .consumeWith(result -> {
                    assertNotNull(result.getResponseBody());
                    assertTrue(result.getResponseBody().contains("Homer"));
                    assertTrue(result.getResponseBody().contains("742 Evergreen Terrace"));
                    assertTrue(result.getResponseBody().contains("(939) 555-0113"));
                });
    }
}
