package com.InvoicifyPro.InvoicifyPro.dto.dtoEntite;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrderDTO {

    private Long id;
    private LocalDate date;
    public int totalDesCommandes;
}
