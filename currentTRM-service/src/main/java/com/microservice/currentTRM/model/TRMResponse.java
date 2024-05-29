package com.microservice.currentTRM.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TRMResponse {
    private Map<String, Double> rates;
}
