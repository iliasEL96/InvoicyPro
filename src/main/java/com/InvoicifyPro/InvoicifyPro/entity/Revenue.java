package com.InvoicifyPro.InvoicifyPro.entity;

import com.InvoicifyPro.InvoicifyPro.enums.Revenue.RevenueType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDate;



@Getter
@Setter
@Entity
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(0)
    private BigDecimal montant;

    @Enumerated(EnumType.STRING)
    private RevenueType revenueType;

    private LocalDate date;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "accounting_id")
    private Accounting accounting;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_id")
    private Order order;
}
