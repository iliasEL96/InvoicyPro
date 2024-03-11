package com.InvoicifyPro.InvoicifyPro.dto.mapper;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.ExpenseDTO;
import com.InvoicifyPro.InvoicifyPro.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    @Mapping( source = "accounting.id", target = "accountingId")
    public ExpenseDTO expenseToExpenseDTO(Expense expense);

    public Expense expenseDTOToExpense (ExpenseDTO dto);

}
