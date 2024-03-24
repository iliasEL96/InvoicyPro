package com.InvoicifyPro.InvoicifyPro.repositories;

import com.InvoicifyPro.InvoicifyPro.dto.dtoEntite.AccountingDTO;
import com.InvoicifyPro.InvoicifyPro.entity.Accounting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AccountingRepository extends JpaRepository<Accounting, Long> {

    public Optional<Accounting> findByDate(LocalDate date);
}
