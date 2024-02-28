package com.InvoicifyPro.InvoicifyPro.entity;

import com.InvoicifyPro.InvoicifyPro.enums.Refund.RefundMethod;
import com.InvoicifyPro.InvoicifyPro.enums.Refund.RefundType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal montantRemboursement;

    @Enumerated(EnumType.STRING)
    private RefundMethod refundMethod;

    @Enumerated(EnumType.STRING)
    private RefundType refundType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn (name = "accounting_id")
    private Accounting accounting;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Refund_client",
            joinColumns = @JoinColumn(name = "refund_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;
}
