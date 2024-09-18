package org.example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="driver")
public class Driver extends Employee{
    private String qualification;

    @ManyToMany(mappedBy = "drivers", fetch = FetchType.LAZY)
    private Set<Transportation> transportation;

    public Driver() {
    }

    public Driver(String name, String lastName, String qualification, double salary) {
        super(name, lastName, salary);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Driver{" +
                super.toString() +
                "qualification='" + qualification + '\'' +
                '}';
    }
}
