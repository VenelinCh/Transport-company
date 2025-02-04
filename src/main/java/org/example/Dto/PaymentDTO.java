package org.example.Dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import org.example.entity.Client;
import org.example.entity.Company;
import org.example.entity.Transportation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PaymentDTO {
//    private Client client;
//    private Transportation transportation;
//    private Company toCompany;
    private long id;
    private LocalDate paid;
    private BigDecimal cost;
    public PaymentDTO(long id, LocalDate paid, BigDecimal cost){
        this.id = id;
        this.paid = paid;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", paid=" + paid +
                ", cost=" + cost +
                '}';
    }
}
