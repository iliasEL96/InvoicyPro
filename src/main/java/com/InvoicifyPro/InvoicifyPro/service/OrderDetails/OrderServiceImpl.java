package com.InvoicifyPro.InvoicifyPro.service.OrderDetails;


import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.OrderDetailsDTO;
import com.InvoicifyPro.InvoicifyPro.dto.mapper.OrderMapper;
import com.InvoicifyPro.InvoicifyPro.entity.OrderDetails;
import com.InvoicifyPro.InvoicifyPro.exception.ResourceNotFoundException;
import com.InvoicifyPro.InvoicifyPro.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderServiceImpl implements OrderService {


    private final OrderDetailsRepository orderDetailsRepository;

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderDetailsRepository orderDetailsRepository, OrderMapper orderMapper) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.orderMapper = orderMapper;
    }


    @Override
    public List<OrderDetailsDTO> findAll() {

        return orderDetailsRepository.findAll().stream().map(orderMapper::orderToOrderDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDetailsDTO findById(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order", id));
        return orderMapper.orderToOrderDTO(orderDetails) ;
    }

    @Override
    @Transactional
    public OrderDetailsDTO save(OrderDetailsDTO orderdto) {
    OrderDetails orderDetails = orderMapper.orderDTOToOrder(orderdto);
        orderDetailsRepository.save(orderDetails);
        return orderMapper.orderToOrderDTO(orderDetails);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(!orderDetailsRepository.existsById(id)){
            throw new ResourceNotFoundException("Order",id );
        }
        orderDetailsRepository.deleteById(id);
    }
}
