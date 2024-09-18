package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.query.sqm.produce.function.StandardFunctionReturnTypeResolvers;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="company")
public class Company extends BaseEntity{
    private String name;

    private String country;
    private String city;
    BigDecimal income;
    @ManyToMany(mappedBy = "companies")
    private Set<Owner> ownews;
    @OneToMany(mappedBy = "company")
    private Set<Vehicle> vehicles;
    @ManyToMany(mappedBy = "companies",fetch = FetchType.LAZY)
    private Set<Employee> employees;
    public Company() {
    }

    public Company(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public Set<Owner> getOwnews() {
        return ownews;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public void setOwnews(Set<Owner> ownews) {
        this.ownews = ownews;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", income=" + income +
                '}';
    }
}
