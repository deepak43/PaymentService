package com.techailez.PaymentService.dao;

import com.techailez.PaymentService.type.PaymentMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "TRANSACTION_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "PAYMENT_MODE")
    private PaymentMode paymentMode;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name = "PAYMENT_DATE")
    private Instant paymentDate;

    @Column(name = "STATUS")
    private String paymentStatus;

    @Column(name = "AMOUNT")
    private Long amount;

}
