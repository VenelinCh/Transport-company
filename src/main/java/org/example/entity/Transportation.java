package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "transportation")
public class Transportation extends BaseEntity{
    private String startingPoint;
    private TypeTransport typeTransport;
    private String destination;
    private BigDecimal price;
    private LocalDate startDate;
    private LocalDate finishDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Driver> drivers;
    @ManyToOne(fetch = FetchType.LAZY)
    private Company companyClient;


    public Transportation() {
    }

    public Transportation(String startingPoint, String destination, LocalDate startDate, LocalDate finishDate, Vehicle vehicle, Set<Driver> drivers, Company companyClient, BigDecimal price) {
        this.startingPoint = startingPoint;
        this.typeTransport = typeTransport;
        this.destination = destination;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.vehicle = vehicle;
        this.drivers = drivers;
        this.companyClient = companyClient;
        this.price = price;
    }
    public Transportation(TypeTransport typeTransport,String startingPoint, String destination, LocalDate startDate, LocalDate finishDate, Vehicle vehicle, Set<Driver> drivers, Company companyClient) {
        this.startingPoint = startingPoint;
        this.typeTransport = typeTransport;
        this.destination = destination;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.vehicle = vehicle;
        this.drivers = drivers;
        this.companyClient = companyClient;
    }
    public Transportation(TypeTransport typeTransport,String startingPoint, String destination, LocalDate startDate, LocalDate finishDate, Vehicle vehicle, Set<Driver> drivers, Company companyClient, Set<Client> clients, boolean paid) {
        this.startingPoint = startingPoint;
        this.typeTransport = typeTransport;
        this.destination = destination;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.vehicle = vehicle;
        this.drivers = drivers;
        this.companyClient = companyClient;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Company getCompanyClient() {
        return companyClient;
    }

    public void setCompanyClient(Company companyClient) {
        this.companyClient = companyClient;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "startingPoint='" + startingPoint + '\'' +
                ", typeTransport=" + typeTransport +
                ", destination='" + destination + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
