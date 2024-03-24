package com.InvoicifyPro.InvoicifyPro.dto.dtoEntite;

import com.InvoicifyPro.InvoicifyPro.dto.SimpleDTO;
import com.InvoicifyPro.InvoicifyPro.enums.Revenue.RevenueType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class RevenueDTO implements SimpleDTO {

    private Long id;

    private BigDecimal montant;

    private RevenueType revenueType;

    private LocalDate date;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long accountingId;

    private Long orderId;
}
