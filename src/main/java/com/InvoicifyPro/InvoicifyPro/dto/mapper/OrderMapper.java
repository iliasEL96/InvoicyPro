package com.InvoicifyPro.InvoicifyPro.dto.mapper;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.OrderDTO;
import com.InvoicifyPro.InvoicifyPro.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    public OrderDTO orderToOrderDTO(Order order);

    public Order orderDTOToOrder(OrderDTO dto);



}
