package com.organimaster.org.controller;

import com.organimaster.org.model.Supplier;
import com.organimaster.org.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/api/supplier/name")
    public List<Supplier> getSupplierIdName() {
        return supplierService.getSuppliersIdName();
    }
}
