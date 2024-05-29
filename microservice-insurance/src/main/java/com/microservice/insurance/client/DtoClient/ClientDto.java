package com.microservice.insurance.client.DtoClient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Integer id_client;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private long TRMid;
}