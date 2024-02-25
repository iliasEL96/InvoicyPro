package com.InvoicifyPro.InvoicifyPro.repositories;

import com.InvoicifyPro.InvoicifyPro.entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
