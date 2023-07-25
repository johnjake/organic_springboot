package com.organimaster.org.services;

import com.organimaster.org.model.Supplier;
import com.organimaster.org.repository.SupplierRepository;
import com.organimaster.org.utils.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getSuppliersIdName() {
        var supplierData = supplierRepository.retrieveIdAndSupplierName();
        return IterableUtils.mapToObjectList(supplierData, this::mapToSupplier);
    }

    private Supplier mapToSupplier(Object[] data) {
        Supplier supplier = new Supplier();
        supplier.setId(((Number) data[0]).longValue());
        supplier.setSupplierName((String) data[1]);
        return supplier;
    }
}
