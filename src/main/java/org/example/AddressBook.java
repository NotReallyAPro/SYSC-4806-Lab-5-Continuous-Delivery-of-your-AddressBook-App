package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies;

    public AddressBook() {
        buddies = new ArrayList<BuddyInfo>();
    }

    public Integer getId() {
        return id;
    }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public int getSize() {
        return buddies.size();
    }

    public BuddyInfo getElementAt(int i) {
        return buddies.get(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            sb.append(getElementAt(i).toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }

        AddressBook other = (AddressBook) o;

        if (getSize() != other.getSize()) {
            return false;
        }

        for (int i = 0; i < getSize(); i++) {
            if (!this.getElementAt(i).equals(other.getElementAt(i))) {
                return false;
            }
        }

        return true;
    }
}

