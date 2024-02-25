package com.InvoicifyPro.InvoicifyPro.entity;

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
public class Accounting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal  benefQuotidien;

    private double margeQuotidien;

    private double roasQuotidien;

    private BigDecimal  benefTotal_AvantImpot;

    private double margeAvantImpot;

    private double roasTotal;

    private BigDecimal  chiffreDaffaire;

    private BigDecimal  duAUrssaf;

    private BigDecimal benefTotalApresImpot;

    private double margeTotalApresImpot;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    private Boolean isRefund ;

    @OneToMany(mappedBy = "accounting", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Charge> charges;

    @OneToMany(mappedBy = "accounting", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Revenu> revenus;

    @OneToMany(mappedBy = "accounting", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Refund> refunds;
}
