package com.InvoicifyPro.InvoicifyPro.event.listners;

import com.InvoicifyPro.InvoicifyPro.entity.Accounting;
import com.InvoicifyPro.InvoicifyPro.entity.Expense;
import com.InvoicifyPro.InvoicifyPro.event.AccountingEvent;
import com.InvoicifyPro.InvoicifyPro.repositories.AccountingRepository;
import com.InvoicifyPro.InvoicifyPro.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class AccountingEventHandler {


    private final AccountingRepository accountingRepository;

    private final ExpenseRepository expenseRepository;

    @Autowired
    public AccountingEventHandler(AccountingRepository accountingRepository, ExpenseRepository expenseRepository) {
        this.accountingRepository = accountingRepository;
        this.expenseRepository = expenseRepository;
    }

    @Transactional
    @EventListener
    public void handleAccountingCheckEvent(AccountingEvent<?> event) {
        Object entity = event.getEntity();
        LocalDate date = event.getDate();

        Accounting accounting = accountingRepository.findByDate(date)
                .orElseGet(() -> {
                    Accounting newAccounting = new Accounting();
                    newAccounting.setDate(date);
                    return accountingRepository.save(newAccounting);
                });

        if (entity instanceof Expense expense) {
            expense.setAccounting(accounting);
            expenseRepository.save(expense);
        }

    }
}
