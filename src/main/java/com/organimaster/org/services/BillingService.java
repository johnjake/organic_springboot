package com.organimaster.org.services;

import com.organimaster.org.dto.BillingDTO;
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

    public Billing saveBilling(BillingDTO billing) {
        var bill = new Billing();
        bill.setFirstName(billing.getFirstName());
        bill.setLastName(billing.getLastName());
        bill.setCountry(billing.getCountry());
        bill.setAddress(billing.getAddress());
        bill.setTown(billing.getTown());
        bill.setState(billing.getState());
        bill.setZipCode(billing.getZipCode());
        bill.setPhone(billing.getPhone());
        bill.setEmail(billing.getEmail());
        bill.setShipToAddress(billing.getShipToAddress());
        bill.setUserId(billing.getUserId());
        return billingRepository.save(bill);
    }

    public Billing getBillingById(Long id) {
        return billingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Billing with ID " + id + " not found"));
    }

    public Billing updateBilling(Long id, Billing billing) {
        Billing existingBilling = getBillingById(id);
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
        existingBilling.setUserId(existingBilling.getUserId());
        return billingRepository.save(existingBilling);
    }

    public void deleteBilling(Long id) {
        Billing billing = getBillingById(id);
        billingRepository.delete(billing);
    }
}
