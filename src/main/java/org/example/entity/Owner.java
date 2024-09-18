package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name="owner")
public class Owner extends Person{
    @ManyToMany
    private Set<Company> companies;

    public Owner() {
    }

    public Owner(String name, String lastName, Set<Company> companies) {
        super(name, lastName);
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "Owner{" +
                super.toString()+
                ", companies=" + companies +
                '}';
    }
}
