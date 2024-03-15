package com.InvoicifyPro.InvoicifyPro.service.order;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.OrderDTO;

import java.util.List;

public interface OrderService {

    public List<OrderDTO> findAll();

    public OrderDTO findById(Long id);

    public OrderDTO save(OrderDTO orderdto);

    public void deleteById(Long id);

}
