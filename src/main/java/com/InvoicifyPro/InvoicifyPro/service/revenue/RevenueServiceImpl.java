package com.InvoicifyPro.InvoicifyPro.service.revenue;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.RevenueDTO;
import com.InvoicifyPro.InvoicifyPro.dto.mapper.RevenueMapper;
import com.InvoicifyPro.InvoicifyPro.entity.Revenue;
import com.InvoicifyPro.InvoicifyPro.exception.ResourceNotFoundException;
import com.InvoicifyPro.InvoicifyPro.repositories.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RevenueServiceImpl implements RevenueService{

    private final RevenueRepository revenueRepository;
    private final RevenueMapper revenueMapper ;

    @Autowired
    public RevenueServiceImpl(RevenueRepository revenueRepository, RevenueMapper revenueMapper) {
        this.revenueRepository = revenueRepository;
        this.revenueMapper = revenueMapper;
    }

    @Override
    public List<RevenueDTO> findAll() {
        return revenueRepository.findAll().stream().map(revenueMapper::revenueToRevenueDTO).collect(Collectors.toList());
    }

    @Override
    public RevenueDTO findById(Long id) {
        Revenue revenue = revenueRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Revenue", id));

        return revenueMapper.revenueToRevenueDTO(revenue);
    }

    @Override
    @Transactional
    public RevenueDTO save(RevenueDTO revenueDTO) {
        Revenue revenue = revenueMapper.revenueDTOToRevenu(revenueDTO);
        revenueRepository.save(revenue);
        return revenueMapper.revenueToRevenueDTO(revenue);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(revenueRepository.existsById(id)){
            throw new ResourceNotFoundException("Revenue",id );
        }
        revenueRepository.deleteById(id);
    }
}
