package com.InvoicifyPro.InvoicifyPro.controller;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RefundDTO;
import com.InvoicifyPro.InvoicifyPro.service.refund.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/refund")
public class RefundController {

    private final RefundService refundService;

    @Autowired
    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }


    @GetMapping
    public List<RefundDTO> GetAllRefunds(){
        return refundService.findAll();
    }

    @GetMapping("/{id}")
    public RefundDTO getRefundById(@PathVariable Long id){
       return refundService.findById(id);
    }

    @PostMapping
    public RefundDTO createRefund(@RequestBody RefundDTO refundDTO){
        return refundService.save(refundDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRefund(@PathVariable Long id){
         refundService.deleteById(id);
    }

}
