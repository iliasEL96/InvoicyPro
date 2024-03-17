
package com.InvoicifyPro.InvoicifyPro.controller;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.AccountingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.InvoicifyPro.InvoicifyPro.service.accounting.AccountingService;

import java.util.List;

@RestController
@RequestMapping("api/accounting")
public class AccountingController {

    private final AccountingService accountingService;

    @Autowired
    public AccountingController(AccountingService accountingServiceImpl){
        this.accountingService = accountingServiceImpl;
    }

    @GetMapping
    public List<AccountingDTO> getAllAccountings(){
        return accountingService.findAll();
    }

    @GetMapping("/{id}")
    public AccountingDTO getAccountingById(@PathVariable Long id){
        return accountingService.findById(id);
    }

    @PostMapping
    public AccountingDTO createAccounting(@RequestBody AccountingDTO accountingDTO){
        return accountingService.save(accountingDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAccounting(@PathVariable Long id ){
        accountingService.deleteById(id);

    }

}

