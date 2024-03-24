package com.InvoicifyPro.InvoicifyPro.entity;

import com.InvoicifyPro.InvoicifyPro.dto.Identifiable;
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
public class Accounting implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal  benefQuotidien;

    private double margeQuotidien;

    private double roasQuotidien;

    private BigDecimal  benefTotalAvantImpot;

    private double margeAvantImpot;

    private double roasTotal;

    private BigDecimal  chiffreDaffaire;

    private BigDecimal  duAUrssaf;

    private BigDecimal benefTotalApresImpot;

    private double margeTotalApresImpot;

    private BigDecimal totalExpenses;

    private BigDecimal totalRevenues;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    private Boolean isRefund ;

    @OneToMany(mappedBy = "accounting", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Expense> expenses;

    @OneToMany(mappedBy = "accounting", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Revenue> revenues;

    @OneToMany(mappedBy = "accounting", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Refund> refunds;
}
