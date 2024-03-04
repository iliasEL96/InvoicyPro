package com.InvoicifyPro.InvoicifyPro.dto.dtoEntite;


import com.InvoicifyPro.InvoicifyPro.enums.expense.ExpenseType;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
public class ExpenseDTO {

    private Long id;

    private ExpenseType type;

    private BigDecimal montant;
    private LocalDate date;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private Long accountingId;
}
