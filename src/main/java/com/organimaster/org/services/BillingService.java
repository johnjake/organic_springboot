package com.organimaster.org.services;

import com.organimaster.org.model.Billing;
import com.organimaster.org.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    private final BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public Billing saveBilling(Billing billing) {
        // Add any business logic or validation before saving if needed
        return billingRepository.save(billing);
    }

    public Billing getBillingById(Long id) {
        return billingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Billing with ID " + id + " not found"));
    }

    public Billing updateBilling(Long id, Billing billing) {
        Billing existingBilling = getBillingById(id);

        // Update the existing billing with the new data
        existingBilling.setFirstName(billing.getFirstName());
        existingBilling.setLastName(billing.getLastName());
        existingBilling.setCountry(billing.getCountry());
        existingBilling.setAddress(billing.getAddress());
        existingBilling.setTown(billing.getTown());
        existingBilling.setState(billing.getState());
        existingBilling.setZipCode(billing.getZipCode());
        existingBilling.setPhone(billing.getPhone());
        existingBilling.setEmail(billing.getEmail());
        existingBilling.setShipToAddress(billing.getShipToAddress());
        var ds = existingBilling.getUserId();
        existingBilling.setUserId(ds);

        return billingRepository.save(existingBilling);
    }

    public void deleteBilling(Long id) {
        Billing billing = getBillingById(id);
        billingRepository.delete(billing);
    }
}
