package com.techailez.PaymentService.service;

import com.techailez.PaymentService.dao.PaymentDetails;
import com.techailez.PaymentService.dto.request.PaymentRequest;
import com.techailez.PaymentService.dto.response.PaymentResponse;
import com.techailez.PaymentService.repository.PaymentDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{


    @Autowired
    private PaymentDetailsRepository repository;

    @Override
    public Long doPayment(PaymentRequest request) {

        log.info("Recording payment details : {}", request);

        PaymentDetails details = PaymentDetails.builder()
                .paymentDate(Instant.now())
                .amount(request.getAmount())
                .paymentMode(request.getPaymentMode())
                .paymentStatus("SUCCESS")
                .orderId(request.getOrderId())
                .referenceNumber(request.getReferenceNumber())
                .build();

        PaymentDetails saved = repository.save(details);

        log.info("Recorded payment details successfully with id: {}", saved.getId());

        return saved.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(Long orderId) {
        log.info("Getting payment details for order id : {}", orderId);
        PaymentDetails details = repository.findByOrderId(orderId);

        PaymentResponse response = PaymentResponse.builder()
                .paymentId(details.getId())
                .orderId(details.getOrderId())
                .amount(details.getAmount())
                .paymentDate(details.getPaymentDate())
                .paymentMode(details.getPaymentMode())
                .status(details.getPaymentStatus())
                .build();

        return response;
    }
}
