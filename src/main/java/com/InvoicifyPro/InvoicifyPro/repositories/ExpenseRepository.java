package com.InvoicifyPro.InvoicifyPro.repositories;


import com.InvoicifyPro.InvoicifyPro.entity.Expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    public List<Expense> findAllByAccountingId(Long accountingId);
}
