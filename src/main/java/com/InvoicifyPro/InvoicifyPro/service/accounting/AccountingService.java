package com.InvoicifyPro.InvoicifyPro.service.accounting;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.AccountingDTO;
import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.ExpenseDTO;
import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RevenueDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AccountingService {

    public List<AccountingDTO> findAll();
    public AccountingDTO findById(Long id);
    public AccountingDTO save (AccountingDTO accountingDTO);
    public void deleteById(Long id);

    public BigDecimal calculateTotalExpenses(Long id);
    public BigDecimal calculateBenefQuotidien(RevenueDTO revenueDTO);




}
