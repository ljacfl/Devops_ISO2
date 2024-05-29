package com.microservice.insurance.client;

import com.microservice.insurance.client.DtoClient.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-client", url = "localhost:8070/api/v1")
public interface UserClient {
    @GetMapping("client/{id}")
    ClientDto findClientById(@PathVariable("id") Integer id);
}