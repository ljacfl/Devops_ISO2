package com.microservice.currentTRM.controller;

import com.microservice.currentTRM.service.TrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trm")
public class TRMController {
    private final TrmService trmService;

    @Autowired
    public TRMController(TrmService trmService) {
        this.trmService = trmService;
    }

    @GetMapping
    public Double getCurrentTRM() {
        return trmService.getCurrentTRM();
    }
}
