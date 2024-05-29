package com.microservice.insurance.model.entity.Factory;

import com.microservice.insurance.model.entity.Factory.paymentType.CashPayment;
import com.microservice.insurance.model.entity.Factory.paymentType.InstallmentPayment;

public class PaymentTypeFactory {

    public PaymentType createPaymentType(int numberOfInstallments) {
        if (numberOfInstallments > 1) {
            return new InstallmentPayment();
        } else if (numberOfInstallments == 1) {
            return new CashPayment();
        } else {
            throw new IllegalArgumentException("Invalid number of installments");
        }
    }
}
