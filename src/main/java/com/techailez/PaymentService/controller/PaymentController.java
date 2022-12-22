package com.techailez.PaymentService.controller;

import com.techailez.PaymentService.dto.request.PaymentRequest;
import com.techailez.PaymentService.dto.response.PaymentResponse;
import com.techailez.PaymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest request) {
        Long paymentId = service.doPayment(request);
        return new ResponseEntity<>(paymentId, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<PaymentResponse> getPaymentDetailsById(@PathVariable Long id) {
        PaymentResponse response = service.getPaymentDetailsByOrderId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
