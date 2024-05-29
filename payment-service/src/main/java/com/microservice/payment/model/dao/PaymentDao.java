package com.microservice.payment.model.dao;

import com.microservice.payment.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends MongoRepository<Payment, Integer> {
}
