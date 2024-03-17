package com.InvoicifyPro.InvoicifyPro.controller;


import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.OrderDTO;
import com.InvoicifyPro.InvoicifyPro.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders(){
        return orderService.findAll();
    }


    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @PostMapping
    public OrderDTO createOrder( @RequestBody OrderDTO orderDTO){
        return orderService.save(orderDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteById(id);
    }


}
