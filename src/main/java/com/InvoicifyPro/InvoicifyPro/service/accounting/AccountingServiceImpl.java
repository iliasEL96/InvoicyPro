package com.InvoicifyPro.InvoicifyPro.service.accounting;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.AccountingDTO;
import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.ExpenseDTO;
import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RevenueDTO;
import com.InvoicifyPro.InvoicifyPro.dto.mapper.AccountingMapper;
import com.InvoicifyPro.InvoicifyPro.entity.Accounting;
import com.InvoicifyPro.InvoicifyPro.exception.ResourceNotFoundException;
import com.InvoicifyPro.InvoicifyPro.repositories.AccountingRepository;
import com.InvoicifyPro.InvoicifyPro.service.expense.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountingServiceImpl implements AccountingService{

    private final AccountingRepository accountingRepository;

    private final AccountingMapper accountingMapper;

    private final ExpenseService expenseService;

    @Autowired
    public AccountingServiceImpl(AccountingRepository accountingRepository, AccountingMapper accountingMapper, ExpenseService expenseService){
        this.accountingRepository = accountingRepository;
        this.accountingMapper = accountingMapper;
        this.expenseService = expenseService;
    }

    @Override
    public List<AccountingDTO> findAll() {
        return accountingRepository.findAll().stream().map(accountingMapper::accountingToAccountingDTO).collect(Collectors.toList());
    }

    @Override
    public AccountingDTO findById(Long id) {
    Accounting accounting = accountingRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("Accounting",id ));
        return accountingMapper.accountingToAccountingDTO(accounting) ;
    }

    @Override
    @Transactional
    public AccountingDTO save(AccountingDTO dto) {
        Accounting accounting = accountingMapper.accountingDTOToAccounting(dto);
        accountingRepository.save(accounting);
        return accountingMapper.accountingToAccountingDTO(accounting);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(accountingRepository.existsById(id)){
            throw new ResourceNotFoundException("Accounting",id );
        }
        accountingRepository.deleteById(id);
    }

    @Override
    public BigDecimal calculateTotalExpenses(Long id) {
        List<ExpenseDTO> expenses = expenseService.findAllByAccountingId(id);
        return expenses.stream()
                .map(ExpenseDTO::getMontant)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal calculateBenefQuotidien(RevenueDTO revenueDTO) {
        return null;
    }
}
