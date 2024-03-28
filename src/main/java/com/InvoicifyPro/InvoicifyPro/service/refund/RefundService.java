package com.InvoicifyPro.InvoicifyPro.service.refund;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RefundDTO;

import java.math.BigDecimal;
import java.util.List;

public interface RefundService {

    public List<RefundDTO> findAll();

    public RefundDTO findById(Long id);

    public List<RefundDTO> findAllByAccountingId(Long accountingId);

    public RefundDTO save(RefundDTO refundDTO);

    public void deleteById(Long id);
}
