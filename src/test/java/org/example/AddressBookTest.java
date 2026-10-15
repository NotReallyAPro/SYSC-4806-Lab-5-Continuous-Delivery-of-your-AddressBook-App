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
    void getId() {
        book.setId(100);
        assertEquals(100, book.getId());
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
        assertEquals(1, book.getSize());
        book.removeBuddy(buddy);
        assertEquals(0, book.getSize());
    }

    @Test
    void getBuddies() {
        BuddyInfo buddy1 = new BuddyInfo("Homer", "742 Evergreen Terrace", "(939) 555-0113");
        BuddyInfo buddy2 = new BuddyInfo("Marge", "742 Evergreen Terrace", "(939) 555-0113");
        BuddyInfo buddy3 = new BuddyInfo("Bart", "742 Evergreen Terrace", "(939) 555-0113");
        BuddyInfo buddy4 = new BuddyInfo("Lisa", "742 Evergreen Terrace", "(939) 555-0113");
        BuddyInfo buddy5 = new BuddyInfo("Maggie", "742 Evergreen Terrace", "(939) 555-0113");

        book.addBuddy(buddy1);
        book.addBuddy(buddy2);
        book.addBuddy(buddy3);
        book.addBuddy(buddy4);
        book.addBuddy(buddy5);

        assertEquals(buddy1, book.getBuddies().get(0));
        assertEquals(buddy2, book.getBuddies().get(1));
        assertEquals(buddy3, book.getBuddies().get(2));
        assertEquals(buddy4, book.getBuddies().get(3));
        assertEquals(buddy5, book.getBuddies().get(4));
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