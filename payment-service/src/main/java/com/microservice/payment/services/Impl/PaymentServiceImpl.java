package com.microservice.payment.services.Impl;

import com.microservice.payment.model.dao.PaymentDao;
import com.microservice.payment.model.entity.Payment;
import com.microservice.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentDao paymentDao;
    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Payment registerPayment(Payment payment) {
        return paymentDao.save(payment);
    }
}
