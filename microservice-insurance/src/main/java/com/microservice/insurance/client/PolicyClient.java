package com.microservice.insurance.client;

import com.microservice.insurance.client.DtoClient.PolicyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MSVC-INSURANCE-POLICIES", url = "localhost:8050/api/v1")
public interface PolicyClient {

    @GetMapping("policy/{id}")
    PolicyDTO findPolicyById(@PathVariable("id") Integer id);
}
