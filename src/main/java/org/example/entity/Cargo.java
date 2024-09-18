package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "cargo")
public class Cargo extends  BaseEntity{
    private BigDecimal weight;
    @OneToOne
    private Transportation transportation;
}
