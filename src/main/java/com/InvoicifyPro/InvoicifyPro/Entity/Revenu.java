package com.InvoicifyPro.InvoicifyPro.Entity;

import com.InvoicifyPro.InvoicifyPro.Enums.Revenue.TypeRevenue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Revenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;

    @Enumerated(EnumType.STRING)
    private TypeRevenue typeRevenue;

    private LocalDate date;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "accounting_id")
    private Accounting accounting;


    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
}
