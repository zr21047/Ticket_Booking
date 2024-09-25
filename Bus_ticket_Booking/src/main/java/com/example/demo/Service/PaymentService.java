package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Payment;

public interface PaymentService {
	Payment createPayment(Payment payment);
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(Long id);
    
}

