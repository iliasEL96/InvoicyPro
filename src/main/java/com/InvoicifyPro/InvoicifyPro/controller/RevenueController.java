package com.InvoicifyPro.InvoicifyPro.controller;


import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RevenueDTO;
import com.InvoicifyPro.InvoicifyPro.service.revenue.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/revenue")
public class RevenueController {

    private final RevenueService revenueService;


    @Autowired
    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }
    @GetMapping
    public List<RevenueDTO> getAllRevenues(){
        return revenueService.findAll();
    }

    @GetMapping("/{id}")
    public RevenueDTO getRevenueById(@PathVariable Long id){
        return revenueService.findById(id);
    }

    @PostMapping
    public RevenueDTO createRevenue(@RequestBody RevenueDTO revenueDTO){
        return revenueService.save(revenueDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRevenue(@PathVariable Long id){
        revenueService.deleteById(id);
    }

}
