package com.microservice.payment.services;

import com.microservice.payment.model.entity.Payment;

public interface PaymentService {
 Payment registerPayment(Payment payment);
}
