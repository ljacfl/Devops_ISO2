package com.microservice.insurance.model.entity;

import com.microservice.insurance.model.entity.Factory.PaymentType;
import com.microservice.insurance.model.entity.Factory.PaymentTypeFactory;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "insurance")
public class Insurance implements Serializable {
    @Id
    @Column(name = "id_insurance")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_insurance;

    @Column(name = "date_start")
    private Date date_start;
    @Column(name = "price")
    private double price;
    @Column(name = "status")
    private boolean status;
    @Column(name = "num_quotes")
    private int num_quotes;
    @Column(name = "payment_type")
    private String payment_type;
    @Column(name = "id_policy")
    private Integer id_policy;
    @Column(name = "id_client")
    private Integer id_client;

    public void setNumberOfInstallments(int numberOfInstallments) {
        PaymentTypeFactory factory = new PaymentTypeFactory();
        PaymentType payment = factory.createPaymentType(numberOfInstallments);
        this.num_quotes = numberOfInstallments;
        this.payment_type = payment.getPaymentType();
    }
}
