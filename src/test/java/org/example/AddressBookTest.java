package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {
    private AddressBook book;

    @BeforeEach
    void setUp() {
        book = new AddressBook();
    }

    @Test
    void addBuddy() {
        BuddyInfo buddy = new BuddyInfo("John Doe", "1 Street Ave.", "(111) 111-1111");
        book.addBuddy(buddy);
        assertEquals(1, book.getSize());
        assertEquals(buddy, book.getElementAt(0));
    }

    @Test
    void removeBuddy() {
        BuddyInfo buddy = new BuddyInfo("John Doe", "1 Street Ave.", "(111) 111-1111");
        book.addBuddy(buddy);
        book.removeBuddy(buddy);
        assertEquals(0, book.getSize());
    }

    @Test
    void testToString() {
        BuddyInfo buddy1 = new BuddyInfo("John Doe", "1 Street Ave.", "(111) 111-1111");
        BuddyInfo buddy2 = new BuddyInfo();
        book.addBuddy(buddy1);
        book.addBuddy(buddy2);
        assertEquals("John Doe#1 Street Ave.#(111) 111-1111\n" +
                        "Homer#742 Evergreen Terrace#(939) 555-0113\n",
                book.toString()
        );
    }

    @Test
    void testEquals() {
        BuddyInfo buddy = new BuddyInfo("John Doe", "1 Street Ave.", "(111) 111-1111");
        book.addBuddy(buddy);
        AddressBook otherBook = book;
        assertEquals(book, otherBook);
    }
}