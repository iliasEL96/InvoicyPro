package com.InvoicifyPro.InvoicifyPro.service.revenue;
import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RevenueDTO;
import com.InvoicifyPro.InvoicifyPro.entity.Revenue;
import java.util.List;


public interface RevenueService {

    public List<RevenueDTO> findAll();

    public RevenueDTO findById(Long id);

    public RevenueDTO save(RevenueDTO revenueDTO);

    public void deleteById(Long id);

}
