package com.InvoicifyPro.InvoicifyPro.repositories;

import com.InvoicifyPro.InvoicifyPro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
