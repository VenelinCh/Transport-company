package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends Person{

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
