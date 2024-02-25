package com.InvoicifyPro.InvoicifyPro.repositories;

import com.InvoicifyPro.InvoicifyPro.entity.Charge;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeRepository extends JpaRepository<Charge,Long> {
}
