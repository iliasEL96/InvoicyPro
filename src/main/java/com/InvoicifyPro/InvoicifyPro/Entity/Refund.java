package com.InvoicifyPro.InvoicifyPro.Entity;

import com.InvoicifyPro.InvoicifyPro.Enums.Refund.MoyenDeRemboursement;
import com.InvoicifyPro.InvoicifyPro.Enums.Refund.TypeRemboursement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montantRemboursement;

    @Enumerated(EnumType.STRING)
    private MoyenDeRemboursement moyenDeRemboursement;

    @Enumerated(EnumType.STRING)
    private TypeRemboursement typeRemboursement;

    @ManyToOne
    @JoinColumn (name = "accounting_id")
    private Accounting accounting;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @ManyToMany
    @JoinTable(
            name = "Refund_client",
            joinColumns = @JoinColumn(name = "refund_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;
}
