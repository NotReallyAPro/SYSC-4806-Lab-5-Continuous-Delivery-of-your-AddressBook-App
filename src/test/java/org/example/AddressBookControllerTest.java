package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureRestTestClient
class AddressBookControllerTest {

    @Autowired
    private RestTestClient restTestClient;

    @MockitoBean
    private AddressBookRepository addressBookRepository;

    @Test
    void getAddressBookReturnsPage() {
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(new BuddyInfo("Homer", "742 Evergreen Terrace", "(939) 555-0113"));

        when(addressBookRepository.findById(1)).thenReturn(Optional.of(addressBook));

        restTestClient.get()
                .uri("/addressbooklist?id=1")
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