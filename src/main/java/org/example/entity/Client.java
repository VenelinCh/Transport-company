package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "client")
public class Client extends Person{
    @ManyToMany(mappedBy = "clients")
    private Set<Transportation> transportation;
///облисли следните промени: премахни transportation
    ///добави
    //public Person person;
    //public Company company;
    public Client() {
    }

    public Client(String name, String lastName) {
        super(name, lastName);
    }

    @Override
    public String toString() {
        return "Client{" +
                super.toString() +
                "}";
    }
}
