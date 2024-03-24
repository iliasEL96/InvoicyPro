package com.InvoicifyPro.InvoicifyPro.dto.dtoEntite;


import com.InvoicifyPro.InvoicifyPro.dto.SimpleDTO;
import com.InvoicifyPro.InvoicifyPro.enums.expense.ExpenseType;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class ExpenseDTO implements SimpleDTO {

    private Long id;

    private ExpenseType type;

    private BigDecimal montant;
    private LocalDate date;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long accountingId;
}
