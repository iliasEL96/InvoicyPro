package com.InvoicifyPro.InvoicifyPro.repositories;

import com.InvoicifyPro.InvoicifyPro.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
