package com.InvoicifyPro.InvoicifyPro.Entity;


import com.InvoicifyPro.InvoicifyPro.Enums.Charge.TypeDepense;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeDepense type;

    private double montant;
    private LocalDate date;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "accounting_id")
    private Accounting accounting;
}
