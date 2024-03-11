package com.InvoicifyPro.InvoicifyPro.dto.dtoEntite;

import com.InvoicifyPro.InvoicifyPro.dto.SimpleDTO;
import com.InvoicifyPro.InvoicifyPro.enums.Refund.RefundMethod;
import com.InvoicifyPro.InvoicifyPro.enums.Refund.RefundType;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class RefundDTO implements SimpleDTO {

    private Long id;

    private BigDecimal montantRemboursement;

    private RefundMethod refundMethod;

    private RefundType refundType;

    private Long accountingId;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private List<Long>  clientsId;

}
