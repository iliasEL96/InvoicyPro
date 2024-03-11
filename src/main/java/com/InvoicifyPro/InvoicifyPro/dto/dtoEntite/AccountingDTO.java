package com.InvoicifyPro.InvoicifyPro.dto.dtoEntite;

import com.InvoicifyPro.InvoicifyPro.dto.SimpleDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AccountingDTO implements SimpleDTO {

    private Long id;

    private BigDecimal  benefQuotidien;

    private double margeQuotidien;

    private double roasQuotidien;

    private BigDecimal  benefTotalAvantImpot;

    private double margeAvantImpot;

    private double roasTotal;

    private BigDecimal  chiffreDaffaire;

    private BigDecimal  duAUrssaf;

    private BigDecimal benefTotalApresImpot;

    private double margeTotalApresImpot;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private Boolean isRefund;

    private List<Long> expenseIds;

    private List<Long> revenueIds;

    private List<Long> refundIds;
}
