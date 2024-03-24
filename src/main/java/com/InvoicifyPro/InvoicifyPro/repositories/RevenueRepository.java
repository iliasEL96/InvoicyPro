package com.InvoicifyPro.InvoicifyPro.repositories;

import com.InvoicifyPro.InvoicifyPro.entity.Revenue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RevenueRepository extends JpaRepository<Revenue,Long> {
    public List<Revenue> findAllByAccountingId( Long accountingId);
}
