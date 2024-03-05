package com.InvoicifyPro.InvoicifyPro.dto.dtoEntite;


import com.InvoicifyPro.InvoicifyPro.dto.SimpleDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO implements SimpleDTO {

    private Long id;

    private String nomComplet;

    private String email;
    private String numeroTelephone;


}
