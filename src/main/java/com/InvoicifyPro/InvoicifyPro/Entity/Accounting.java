package com.InvoicifyPro.InvoicifyPro.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Accounting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double benefQuotidien;
    private double margeQuotidien;
    private double roasQuotidien;
    private double benefTotal_AvantImpot;
    private double margeAvantImpot;
    private double roasTotal;
    private double chiffreDaffaire;
    private double duAUrssaf;
    private double benefTotal_ApresImpot;
    private double margeTotalApresImpot;






    private Boolean isRefund ;

    @OneToMany(mappedBy = "accounting")
    private List<Charge> charges;

    @OneToMany(mappedBy = "accounting")
    private List<Revenu> revenus;

    @OneToMany(mappedBy = "accounting")
    private List<Refund> refund;
}
