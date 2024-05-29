package com.insurance.policies.controller;

import com.insurance.policies.model.entity.Policies;
import com.insurance.policies.service.Impl.PoliciesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PoliciesController {
    @Autowired
    private PoliciesImpl policiesService;

    @GetMapping("policy/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Policies showById(@PathVariable Integer id) {
        return policiesService.findById(id);
    }

    @GetMapping("policy")
    @ResponseStatus(HttpStatus.OK)
    public List<Policies> getAllPolicies() {
        return policiesService.findAllPolicies();
    }

    @PostMapping("policy")
    @ResponseStatus(HttpStatus.CREATED)
    public Policies create(@RequestBody Policies policies) {
        return policiesService.save(policies);
    }

    @PutMapping("policy")
    @ResponseStatus(HttpStatus.CREATED)
    public Policies update(@RequestBody Policies policies) {
        return policiesService.save(policies);
    }

    @DeleteMapping("policy/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        Policies delete = policiesService.findById(id);
        policiesService.delete(delete);
    }
}
