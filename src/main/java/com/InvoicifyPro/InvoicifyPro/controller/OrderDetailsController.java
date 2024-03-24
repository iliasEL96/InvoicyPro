package com.InvoicifyPro.InvoicifyPro.controller;


import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.OrderDetailsDTO;
import com.InvoicifyPro.InvoicifyPro.service.OrderDetails.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderDetailsController {

    private final OrderService orderService;

    @Autowired
    public OrderDetailsController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDetailsDTO> getAllOrders(){
        return orderService.findAll();
    }


    @GetMapping("/{id}")
    public OrderDetailsDTO getOrderById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @PostMapping
    public OrderDetailsDTO createOrder(@RequestBody OrderDetailsDTO orderDetailsDTO){
        return orderService.save(orderDetailsDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteById(id);
    }


}
