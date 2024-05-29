package com.insurance.policies.service;

import com.insurance.policies.model.entity.Policies;

import java.util.List;

public interface IPolicies {
    Policies save(Policies policies);
    Policies findById(Integer id);
    void delete(Policies policies);
    List<Policies> findAllPolicies();
}
