package com.microservice.currentTRM.service;

import com.microservice.currentTRM.model.TRMResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class TrmService {
    private static final String TRM_API_URL = "https://api.exchangerate-api.com/v4/latest/USD";

    public Double getCurrentTRM() {
        RestTemplate restTemplate = new RestTemplate();
        TRMResponse trmResponse = restTemplate.getForObject(TRM_API_URL, TRMResponse.class);
        assert trmResponse != null;
        return trmResponse.getRates().get("COP");
    }
}
