package com.organimaster.org.controller;

import com.organimaster.org.dto.BillingDTO;
import com.organimaster.org.model.Billing;
import com.organimaster.org.services.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/billing")
public class BillingController {
    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping
    public ResponseEntity<Billing> createBilling(@RequestBody BillingDTO billingDTO) {
        Billing savedBilling = billingService.saveBilling(billingDTO);
        return new ResponseEntity<>(savedBilling, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Billing getBilling(@PathVariable Long id) {
        return billingService.getBillingById(id);
    }

    @PutMapping("/{id}")
    public Billing updateBilling(@PathVariable Long id, @RequestBody Billing billing) {
        return billingService.updateBilling(id, billing);
    }

    @DeleteMapping("/{id}")
    public void deleteBilling(@PathVariable Long id) {
        billingService.deleteBilling(id);
    }
}
