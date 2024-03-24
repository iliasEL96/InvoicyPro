package com.InvoicifyPro.InvoicifyPro.service.OrderDetails;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.OrderDetailsDTO;

import java.util.List;

public interface OrderService {

    public List<OrderDetailsDTO> findAll();

    public OrderDetailsDTO findById(Long id);

    public OrderDetailsDTO save(OrderDetailsDTO orderdto);

    public void deleteById(Long id);

}
