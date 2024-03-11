package com.InvoicifyPro.InvoicifyPro.entity;

import com.InvoicifyPro.InvoicifyPro.dto.Identifiable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Entity
public class Client implements Identifiable {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomComplet;

    @Email
    private String email;
    private String numeroTelephone;

    @ManyToMany(mappedBy = "clients", fetch = FetchType.LAZY)
    private List<Refund> refunds;
}
