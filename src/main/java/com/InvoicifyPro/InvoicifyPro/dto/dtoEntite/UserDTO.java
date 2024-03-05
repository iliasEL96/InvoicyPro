package com.InvoicifyPro.InvoicifyPro.dto.dtoEntite;

import com.InvoicifyPro.InvoicifyPro.dto.SimpleDTO;
import com.InvoicifyPro.InvoicifyPro.enums.User.RoleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO implements SimpleDTO {

    private Long id;
    private String nom;
    private String motDePasse;
    private RoleType roleType;
}
