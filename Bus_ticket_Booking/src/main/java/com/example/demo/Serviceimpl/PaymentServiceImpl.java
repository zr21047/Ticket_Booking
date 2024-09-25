package com.example.demo.Serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Payment;
import com.example.demo.Repo.PaymentRepo;
import com.example.demo.Service.PaymentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;
    
    @Override
    public Payment createPayment(Payment payment) {
        payment.setPaymentTime(LocalDateTime.now());
        payment.setPaymentStatus("Success");
        return paymentRepo.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepo.findById(id);
    }

    

   
}

