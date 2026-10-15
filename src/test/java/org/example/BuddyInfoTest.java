package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuddyInfoTest {
    private BuddyInfo buddy;

    @BeforeEach
    void setUp() {
        buddy = new BuddyInfo("John Doe", "1 Street Ave.", "(111) 111-1111");
    }

    @Test
    void getName() {
        assertEquals("John Doe", buddy.getName());
    }

    @Test
    void getAddress() {
        assertEquals("1 Street Ave.", buddy.getAddress());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("(111) 111-1111", buddy.getPhoneNumber());
    }

    @Test
    void getAddressBook() {
        AddressBook book = new AddressBook();
        book.addBuddy(buddy);
        assertEquals(book, buddy.getAddressBook());
    }

    @Test
    void setName() {
        buddy.setName("Jane Doe");
        assertEquals("Jane Doe", buddy.getName());
    }

    @Test
    void setAddress() {
        buddy.setAddress("2 Street Ave.");
        assertEquals("2 Street Ave.", buddy.getAddress());
    }

    @Test
    void setPhoneNumber() {
        buddy.setPhoneNumber("(111) 111-1112");
        assertEquals("(111) 111-1112", buddy.getPhoneNumber());

    }

    @Test
    void testToString() {
        assertEquals("John Doe#1 Street Ave.#(111) 111-1111", buddy.toString());
    }

    @Test
    void testEquals() {
        BuddyInfo otherBuddy = buddy;
        assertEquals(buddy, otherBuddy);
    }
}