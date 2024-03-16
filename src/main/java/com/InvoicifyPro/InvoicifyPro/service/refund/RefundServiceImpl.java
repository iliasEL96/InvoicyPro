package com.InvoicifyPro.InvoicifyPro.service.refund;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RefundDTO;
import com.InvoicifyPro.InvoicifyPro.dto.mapper.RefundMapper;
import com.InvoicifyPro.InvoicifyPro.entity.Refund;
import com.InvoicifyPro.InvoicifyPro.exception.ResourceNotFoundException;
import com.InvoicifyPro.InvoicifyPro.repositories.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RefundServiceImpl implements RefundService {

    private final RefundRepository refundRepository ;

    private final RefundMapper refundMapper ;

    @Autowired
    public RefundServiceImpl(RefundRepository refundRepository, RefundMapper refundMapper) {
        this.refundRepository = refundRepository;
        this.refundMapper = refundMapper;
    }


    @Override
    public List<RefundDTO> findAll() {
        return refundRepository.findAll().stream().map(refundMapper::refundToRefundDTO).collect(Collectors.toList());
    }

    @Override
    public RefundDTO findById(Long id) {
        Refund refund = refundRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Refund", id));
        return refundMapper.refundToRefundDTO(refund);
    }

    @Override
    public RefundDTO save(RefundDTO refundDTO) {
        Refund refund = refundMapper.refundDTOToRefund(refundDTO);
        refundRepository.save(refund);
        return refundMapper.refundToRefundDTO(refund);
    }

    @Override
    public void deleteById(Long id) {
        refundRepository.deleteById(id);
    }

}
