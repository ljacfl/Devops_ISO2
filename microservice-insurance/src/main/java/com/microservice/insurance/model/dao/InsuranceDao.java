package com.microservice.insurance.model.dao;

import com.microservice.insurance.model.entity.Insurance;
import feign.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InsuranceDao extends CrudRepository<Insurance, Integer> {
    @Query("SELECT i FROM Insurance i WHERE i.id_client = :id_client")
    List<Insurance> findInsurancesByIdClient(@Param("id_client") Integer id_client);

}
