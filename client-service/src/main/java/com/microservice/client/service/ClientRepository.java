package com.microservice.client.service;

import com.microservice.client.model.dto.ClientDto;
import com.microservice.client.model.entity.Client;

import java.util.List;

public interface ClientRepository {
    Client save(ClientDto client);
    Client findById(Integer id);
    void delete(Client client);
    List<Client> findAll();
    boolean existsById(Integer id);
}