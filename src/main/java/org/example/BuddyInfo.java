package org.example;

import jakarta.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private String address;
    private String phoneNumber;

    @ManyToOne
    private AddressBook addressBook = null;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public BuddyInfo() {
        this("Homer", "742 Evergreen Terrace", "(939) 555-0113");
    }

    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return (name + "#" + address + "#" + phoneNumber);
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o.getClass() != getClass()) {
            return false;
        }

        BuddyInfo other = (BuddyInfo) o;

        return (name.equals(other.name) && address.equals(other.address) && phoneNumber.equals(other.phoneNumber));
    }
}
