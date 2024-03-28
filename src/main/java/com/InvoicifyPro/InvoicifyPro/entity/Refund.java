package com.InvoicifyPro.InvoicifyPro.entity;

import com.InvoicifyPro.InvoicifyPro.dto.Identifiable;
import com.InvoicifyPro.InvoicifyPro.enums.Refund.RefundMethod;
import com.InvoicifyPro.InvoicifyPro.enums.Refund.RefundType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Refund implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomComplet;

    private BigDecimal montantRemboursement;

    private LocalDate dateDeCommande;

    private LocalDate dateDeRemboursement;

    @Enumerated(EnumType.STRING)
    private RefundMethod refundMethod;

    @Enumerated(EnumType.STRING)
    private RefundType refundType;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "accounting_id")
    private Accounting accounting;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;
}
