package com.InvoicifyPro.InvoicifyPro.service.accounting;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.AccountingDTO;
import com.InvoicifyPro.InvoicifyPro.dto.mapper.AccountingMapper;
import com.InvoicifyPro.InvoicifyPro.entity.Accounting;
import com.InvoicifyPro.InvoicifyPro.exception.ResourceNotFoundException;
import com.InvoicifyPro.InvoicifyPro.repositories.AccountingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountingServiceImpl implements AccountingService{

    private final AccountingRepository accountingRepository;
    private final AccountingMapper accountingMapper;

    @Autowired
    public AccountingServiceImpl(AccountingRepository accountingRepository, AccountingMapper accountingMapper){
        this.accountingRepository = accountingRepository;
        this.accountingMapper = accountingMapper;
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
        accountingRepository.deleteById(id);
    }
}
