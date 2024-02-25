package com.InvoicifyPro.InvoicifyPro.Entity;

import com.InvoicifyPro.InvoicifyPro.Enums.Users.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private Roles role;
}
