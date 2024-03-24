package com.InvoicifyPro.InvoicifyPro.dto.dtoEntite;

import com.InvoicifyPro.InvoicifyPro.dto.SimpleDTO;
import com.InvoicifyPro.InvoicifyPro.enums.Revenue.RevenueType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class RevenueDTO implements SimpleDTO {

    private Long id;

    private BigDecimal montant;

    private RevenueType revenueType;

    private LocalDate date;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private Long accountingId;

    private Long orderId;
}
