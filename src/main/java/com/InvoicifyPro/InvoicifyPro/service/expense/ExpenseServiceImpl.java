package com.InvoicifyPro.InvoicifyPro.service.expense;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.ExpenseDTO;
import com.InvoicifyPro.InvoicifyPro.dto.mapper.ExpenseMapper;
import com.InvoicifyPro.InvoicifyPro.entity.Expense;
import com.InvoicifyPro.InvoicifyPro.exception.ResourceNotFoundException;
import com.InvoicifyPro.InvoicifyPro.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    @Override
    public List<ExpenseDTO> findAll() {
        return expenseRepository.findAll().stream().map(expenseMapper::expenseToExpenseDTO).collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO findById(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Expense", id));
        return expenseMapper.expenseToExpenseDTO(expense);
    }

    @Override
    public ExpenseDTO save(ExpenseDTO expenseDTO) {
        Expense expense = expenseMapper.expenseDTOToExpense(expenseDTO);
        expenseRepository.save(expense);
        return expenseMapper.expenseToExpenseDTO(expense);
    }

    @Override
    public void deleteById(Long id) {
        expenseRepository.deleteById(id);
    }
}
