package com.microservice.insurance.client.DtoClient;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PolicyDTO {
    private Integer id_policy;
    private String name;
    private String description;
    private double usd_price;
}
