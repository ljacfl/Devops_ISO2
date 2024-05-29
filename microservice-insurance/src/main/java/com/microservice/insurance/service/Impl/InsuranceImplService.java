package com.microservice.insurance.service.Impl;

import com.microservice.insurance.client.DtoClient.ClientDto;
import com.microservice.insurance.client.DtoClient.PolicyDTO;
import com.microservice.insurance.client.PolicyClient;
import com.microservice.insurance.client.UserClient;
import com.microservice.insurance.http.response.ClientByIdResponse;
import com.microservice.insurance.http.response.PolicyByIdResponse;
import com.microservice.insurance.model.dao.InsuranceDao;
import com.microservice.insurance.model.dto.InsuranceDto;
import com.microservice.insurance.model.entity.Insurance;
import com.microservice.insurance.service.IInsurance;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceImplService implements IInsurance {
    @Autowired
    private InsuranceDao insuranceDao;

    @Autowired
    private UserClient userClient;
    @Autowired
    private PolicyClient policyClient;

    @Override
    public List<Insurance> findAll() {
        List<Insurance> insurances = new ArrayList<>();
        insuranceDao.findAll().forEach(insurances::add);
        return insurances;
    }

    // Implementation of the method to save a client
    @Transactional
    @Override
    public Insurance save(InsuranceDto insuranceDto) {
        ClientDto clientDto = userClient.findClientById(insuranceDto.getId_client());
        PolicyDTO policyDto = policyClient.findPolicyById(insuranceDto.getId_policy());

        if (clientDto == null || policyDto == null) {
            return null;
        } else {
            Insurance insurance = Insurance.builder()
                    .id_insurance(insuranceDto.getId_insurance())
                    .date_start(insuranceDto.getDate_start())
                    .price(insuranceDto.getPrice())
                    .status(insuranceDto.isStatus())
                    .num_quotes((insuranceDto.getNum_quotes()))
                    .payment_type(insuranceDto.getPayment_type())
                    .id_policy(insuranceDto.getId_policy())
                    .id_client(insuranceDto.getId_client())
                    .build();

            insurance.setNumberOfInstallments(insuranceDto.getNum_quotes());

            return insuranceDao.save(insurance);
        }
    }

    // Implementation of the method to find a client by its ID
    @Transactional
    @Override
    public Insurance findById(Integer id) {
        return insuranceDao.findById(id).orElse(null);
    }

    // Implementation of the method to delete a client
    @Transactional
    @Override
    public void delete(Insurance client) {
        insuranceDao.delete(client);
    }

    @Override
    public boolean existsById(Integer id) {
        return insuranceDao.existsById(id);
    }

    // Implementation of the method to find a client by its ID
    @Override
    public ClientByIdResponse findClientById(Integer id) {
        ClientDto clientDto = userClient.findClientById(id);
        if (clientDto == null) {
            // El cliente no existe
            return null;
        } else {
            // El cliente existe
            return new ClientByIdResponse(clientDto.getId_client());
        }
    }

    @Override
    public PolicyByIdResponse findPolicyById(Integer id) {
        PolicyDTO policyDto = policyClient.findPolicyById(id);
        if (policyDto == null) {
            // La politica no existe
            return null;
        } else {
            // La politica existe
            return new PolicyByIdResponse(policyDto.getId_policy());
        }
    }

    @Override
    public List<Insurance> findInsurancesByClientId(Integer id) {

        ClientDto clientIdGetter = userClient.findClientById(id);
        if (clientIdGetter == null) {
            return null;
        } else {
            return insuranceDao.findInsurancesByIdClient(id);
        }
    }



} //:D