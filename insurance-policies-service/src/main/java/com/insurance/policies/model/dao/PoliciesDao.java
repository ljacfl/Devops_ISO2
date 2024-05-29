package com.insurance.policies.model.dao;

import com.insurance.policies.model.entity.Policies;
import org.springframework.data.repository.CrudRepository;

public interface PoliciesDao extends CrudRepository <Policies, Integer> {
}