package com.InvoicifyPro.InvoicifyPro.service.refund;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RefundDTO;

import java.util.List;

public interface RefundService {

    public List<RefundDTO> findAll();

    public RefundDTO findById(Long id);

    public RefundDTO save(RefundDTO refundDTO);

    public void deleteById(Long id);
}
