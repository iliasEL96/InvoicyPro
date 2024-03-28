package com.InvoicifyPro.InvoicifyPro.event.listners;

import com.InvoicifyPro.InvoicifyPro.entity.Accounting;
import com.InvoicifyPro.InvoicifyPro.entity.Expense;
import com.InvoicifyPro.InvoicifyPro.entity.Refund;
import com.InvoicifyPro.InvoicifyPro.entity.Revenue;
import com.InvoicifyPro.InvoicifyPro.event.AccountingEvent;
import com.InvoicifyPro.InvoicifyPro.repositories.AccountingRepository;
import com.InvoicifyPro.InvoicifyPro.repositories.ExpenseRepository;
import com.InvoicifyPro.InvoicifyPro.repositories.RefundRepository;
import com.InvoicifyPro.InvoicifyPro.repositories.RevenueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class AccountingEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(AccountingEventHandler.class);

    private final AccountingRepository accountingRepository;

    private final ExpenseRepository expenseRepository;

    private final RefundRepository refundRepository;

    private final RevenueRepository revenueRepository;

    @Autowired
    public AccountingEventHandler(AccountingRepository accountingRepository, ExpenseRepository expenseRepository, RefundRepository refundRepository, RevenueRepository revenueRepository) {
        this.accountingRepository = accountingRepository;
        this.expenseRepository = expenseRepository;
        this.refundRepository = refundRepository;
        this.revenueRepository = revenueRepository;
    }

    @Transactional
    @EventListener
    public void handleAccountingCheckEvent(AccountingEvent<?> event) {
        Object entity = event.getEntity();
        LocalDate date = event.getDate();

        if (date == null) {
            logger.error("AccountingEvent received with null date.");
            return;
        }

        Accounting accounting = accountingRepository.findByDate(date)
                .orElseGet(() -> {
                    logger.info("Creating new Accounting entry for date: {}", date);
                    Accounting newAccounting = new Accounting();
                    newAccounting.setDate(date);
                    return accountingRepository.save(newAccounting);
                });

        if (entity instanceof Expense expense) {
            expense.setAccounting(accounting);
            expenseRepository.save(expense);
            logger.info("Expense entity saved with Accounting id: {}", date);
        } else if (entity instanceof Refund refund) {
            refund.setAccounting(accounting);
            refundRepository.save(refund);
            logger.info("Refund entity saved with Accounting id: {}", date);
        } else if (entity instanceof Revenue revenue) {
            revenue.setAccounting(accounting);
            revenueRepository.save(revenue);
            logger.info("Revenue entity saved with Accounting id: {}", date);
        } else {
            logger.error("Unsupported entity type in AccountingEvent: {}", entity.getClass().getName());
        }


    }
}
