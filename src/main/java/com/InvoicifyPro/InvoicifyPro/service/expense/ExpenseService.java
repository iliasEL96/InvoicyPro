package com.InvoicifyPro.InvoicifyPro.service.expense;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.ExpenseDTO;
import com.InvoicifyPro.InvoicifyPro.entity.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    public List<ExpenseDTO> findAll();

    public ExpenseDTO findById(Long id);

    public ExpenseDTO save(ExpenseDTO expenseDTO);

    public void deleteById(Long id);

}
