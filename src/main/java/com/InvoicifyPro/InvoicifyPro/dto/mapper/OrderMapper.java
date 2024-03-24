package com.InvoicifyPro.InvoicifyPro.dto.mapper;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.OrderDetailsDTO;
import com.InvoicifyPro.InvoicifyPro.entity.OrderDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    public OrderDetailsDTO orderToOrderDTO(OrderDetails orderDetails);

    public OrderDetails orderDTOToOrder(OrderDetailsDTO dto);



}
