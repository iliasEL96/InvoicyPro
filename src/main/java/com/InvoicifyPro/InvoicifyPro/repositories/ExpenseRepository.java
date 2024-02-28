package com.InvoicifyPro.InvoicifyPro.repositories;

import com.InvoicifyPro.InvoicifyPro.entity.Expense;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
