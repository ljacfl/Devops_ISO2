package com.microservice.insurance.model.dto;

import com.microservice.insurance.model.entity.Factory.PaymentType;
import com.microservice.insurance.model.entity.Factory.PaymentTypeFactory;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class InsuranceDto implements Serializable {

    private Integer id_insurance;
    private Date date_start;
    private double price;
    private boolean status;
    private int num_quotes;
    private String payment_type;
    private Integer id_policy;
    private Integer id_client;
}
