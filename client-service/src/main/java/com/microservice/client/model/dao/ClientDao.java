package com.microservice.client.model.dao;

import com.microservice.client.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository <Client, Integer>{
}