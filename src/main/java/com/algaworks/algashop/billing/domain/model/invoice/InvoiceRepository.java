package com.algaworks.algashop.billing.domain.model.invoice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {


    boolean existsByOrderId(String orderId);

    Optional<Invoice> findByOrderId(String orderId);
}
