package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.example.dao.TransportationDao;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity{
   @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

   @ManyToOne(fetch =FetchType.LAZY)
    private Transportation transportation;
    @ManyToOne(fetch =FetchType.LAZY)
    private Company toCompany;
    private LocalDate paid;
    private BigDecimal cost;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public Company getToCompany() {
        return toCompany;
    }

    public void setToCompany(Company toCompany) {
        this.toCompany = toCompany;
    }

    public LocalDate getPaid() {
        return paid;
    }

    public void setPaid(LocalDate paid) {
        this.paid = paid;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Payment() {
    }

    public Payment(Client client, Transportation transportation, Company toCompany) {
        this.client = client;
        this.transportation = transportation;
        this.toCompany = toCompany;
    }
    public Payment(Client client, Transportation transportation, Company toCompany, LocalDate paid,BigDecimal cost) {
        this.client = client;
        this.transportation = transportation;
        this.toCompany = toCompany;
        this.paid = paid;
        this.cost = cost;

    }

    @Override
    public String  toString() {
        return "Payment{" +
                "id=" + this.getId() + ///
//                "client=" + client +
//                ", transportation=" + transportation +
//                ", toCompany=" + toCompany +
                ", cost=" + cost +
                ", paid=" + paid +

                '}';
    }
}
