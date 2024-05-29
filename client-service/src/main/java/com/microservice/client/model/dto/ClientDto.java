package com.microservice.client.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder // Design pattern to create objects with a large number of attributes
public class ClientDto implements Serializable {
    private Integer id_client;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private long TRMid;
}
