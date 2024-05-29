package com.microservice.insurance.service;

import com.microservice.insurance.http.response.ClientByIdResponse;
import com.microservice.insurance.http.response.PolicyByIdResponse;
import com.microservice.insurance.model.dto.InsuranceDto;
import com.microservice.insurance.model.entity.Insurance;

import java.util.List;

public interface IInsurance {
    Insurance save(InsuranceDto insurance);
    Insurance findById(Integer id);
    void delete(Insurance insurance);
    List<Insurance> findAll();
    boolean existsById(Integer id);
    ClientByIdResponse findClientById(Integer id);
    PolicyByIdResponse findPolicyById(Integer id);
    List<Insurance> findInsurancesByClientId(Integer id);

}