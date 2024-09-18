package org.example.entity;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name="employee")
public class Employee extends Person{
   //
    private double salary;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Company> companies;

    public Employee(){
    }

    public Employee(String name, String lastName, double salary) {
        super(name, lastName);
        this.salary = salary;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public double getSalary() {
        return salary;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                ", salary=" + salary +
                '}';
    }
}
