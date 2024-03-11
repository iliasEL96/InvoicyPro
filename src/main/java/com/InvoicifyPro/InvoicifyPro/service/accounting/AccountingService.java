package com.InvoicifyPro.InvoicifyPro.service.accounting;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.AccountingDTO;
import com.InvoicifyPro.InvoicifyPro.entity.Accounting;

import java.util.List;
import java.util.Optional;

public interface AccountingService {

    public List<AccountingDTO> findAll();
    public AccountingDTO findById(Long id);
    public AccountingDTO save (AccountingDTO accountingDTO);
    public void deletebyId (Long id);


}
