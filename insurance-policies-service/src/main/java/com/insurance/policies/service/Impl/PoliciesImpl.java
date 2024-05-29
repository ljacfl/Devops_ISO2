package com.insurance.policies.service.Impl;

import com.insurance.policies.model.dao.PoliciesDao;
import com.insurance.policies.model.entity.Policies;
import com.insurance.policies.service.IPolicies;
import com.netflix.discovery.DiscoveryClient;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoliciesImpl implements IPolicies {

    @Autowired
    private PoliciesDao policiesDao;

    // Implementation of the method to save a policy
    @Transactional
    @Override
    public Policies save(Policies policies) {
        return policiesDao.save(policies);
    }

    // Implementation of the method to find a policy by its ID
    @Override
    public Policies findById(Integer id) {
        return policiesDao.findById(id).orElse(null);
    }

    // Implementation of the method to find all policies
    @Override
    public List<Policies> findAllPolicies() {
        List<Policies> policies = new ArrayList<>();
        policiesDao.findAll().forEach(policies::add);
        return policies;
    }

    // Implementation of the method to delete a policy
    @Override
    public void delete(Policies policies) {
        policiesDao.delete(policies);
    }
}
