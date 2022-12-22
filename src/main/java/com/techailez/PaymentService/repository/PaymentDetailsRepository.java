package com.techailez.PaymentService.repository;

import com.techailez.PaymentService.dao.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {

    PaymentDetails findByOrderId(Long orderId);
}
