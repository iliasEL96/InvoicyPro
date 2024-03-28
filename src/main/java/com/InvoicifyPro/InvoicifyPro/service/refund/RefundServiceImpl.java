package com.InvoicifyPro.InvoicifyPro.service.refund;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RefundDTO;
import com.InvoicifyPro.InvoicifyPro.dto.mapper.RefundMapper;
import com.InvoicifyPro.InvoicifyPro.entity.Refund;
import com.InvoicifyPro.InvoicifyPro.event.AccountingEvent;
import com.InvoicifyPro.InvoicifyPro.event.ClientEvent;
import com.InvoicifyPro.InvoicifyPro.event.RefundEvent;
import com.InvoicifyPro.InvoicifyPro.exception.ResourceNotFoundException;
import com.InvoicifyPro.InvoicifyPro.repositories.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RefundServiceImpl implements RefundService {

    private final RefundRepository refundRepository;

    private final RefundMapper refundMapper;

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public RefundServiceImpl(RefundRepository refundRepository, RefundMapper refundMapper, ApplicationEventPublisher eventPublisher) {
        this.refundRepository = refundRepository;
        this.refundMapper = refundMapper;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<RefundDTO> findAll() {
        return refundRepository.findAll().stream().map(refundMapper::refundToRefundDTO).collect(Collectors.toList());
    }

    @Override
    public RefundDTO findById(Long id) {
        Refund refund = refundRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Refund", id));
        return refundMapper.refundToRefundDTO(refund);
    }

    @Override
    @Transactional
    public RefundDTO save(RefundDTO refundDTO) {
        Refund refund = refundMapper.refundDTOToRefund(refundDTO);
        LocalDate dateDeCommande = refund.getDateDeCommande();
        String NomCompletDuClient = refund.getNomComplet();

        eventPublisher.publishEvent(new AccountingEvent<>(dateDeCommande, refund));
        return refundMapper.refundToRefundDTO(refund);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!refundRepository.existsById(id)) {
            throw new ResourceNotFoundException("Refund", id);
        }
        refundRepository.deleteById(id);
    }

}
