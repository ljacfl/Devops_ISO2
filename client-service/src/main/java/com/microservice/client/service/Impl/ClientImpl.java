package com.microservice.client.service.Impl;

import com.microservice.client.model.dao.ClientDao;
import com.microservice.client.model.dto.ClientDto;
import com.microservice.client.model.entity.Client;
import com.microservice.client.service.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientImpl implements ClientRepository {

    // Dependency injection for the client DAO
    @Autowired
    private ClientDao clienteDao;

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        clienteDao.findAll().forEach(clients::add);
        return clients;
    }

    // Implementation of the method to save a client
    @Transactional
    @Override
    public Client save(ClientDto clientDto) {
        Client client = Client.builder()
                .id_client(clientDto.getId_client())
                .name(clientDto.getName())
                .lastname(clientDto.getLastname())
                .email(clientDto.getEmail())
                .phone(clientDto.getPhone())
                .address(clientDto.getAddress())
                .TRMid(clientDto.getTRMid())
                .build();
        return clienteDao.save(client);
    }

    // Implementation of the method to find a client by its ID
    @Transactional
    @Override
    public Client findById(Integer id) {
        return clienteDao.findById(id).orElse(null);
    }

    // Implementation of the method to delete a client
    @Transactional
    @Override
    public void delete(Client client) {
        clienteDao.delete(client);
    }

    @Override
    public boolean existsById(Integer id) {
        return clienteDao.existsById(id);
    }
}
