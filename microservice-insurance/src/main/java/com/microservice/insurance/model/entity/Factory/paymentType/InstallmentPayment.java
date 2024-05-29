package com.microservice.insurance.model.entity.Factory.paymentType;

import com.microservice.insurance.model.entity.Factory.PaymentType;

public class InstallmentPayment implements PaymentType {
    @Override
    public String getPaymentType() {
        return "installments";
    }

}