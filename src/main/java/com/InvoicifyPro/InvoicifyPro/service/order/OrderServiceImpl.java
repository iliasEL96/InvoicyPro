package com.InvoicifyPro.InvoicifyPro.service.order;


import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.OrderDTO;
import com.InvoicifyPro.InvoicifyPro.dto.mapper.OrderMapper;
import com.InvoicifyPro.InvoicifyPro.entity.Order;
import com.InvoicifyPro.InvoicifyPro.exception.ResourceNotFoundException;
import com.InvoicifyPro.InvoicifyPro.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDTO orderDTO, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }


    @Override
    public List<OrderDTO> findAll() {

        return orderRepository.findAll().stream().map(orderMapper::orderToOrderDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order", id));
        return orderMapper.orderToOrderDTO(order) ;
    }

    @Override
    public OrderDTO save(OrderDTO orderdto) {
    Order order = orderMapper.orderDTOToOrder(orderdto);
        orderRepository.save(order);
        return orderMapper.orderToOrderDTO(order);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
