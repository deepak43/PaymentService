package com.techailez.PaymentService.service;

import com.techailez.PaymentService.dto.request.PaymentRequest;
import com.techailez.PaymentService.dto.response.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest request);

    PaymentResponse getPaymentDetailsByOrderId(Long id);
}
