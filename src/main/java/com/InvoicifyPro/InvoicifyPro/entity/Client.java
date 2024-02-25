package com.InvoicifyPro.InvoicifyPro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Entity
public class Client {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomComplet;

    private String email;
    private String numeroTelephone;

    @ManyToMany(mappedBy = "clients")
    private List<Refund> refunds;
}
