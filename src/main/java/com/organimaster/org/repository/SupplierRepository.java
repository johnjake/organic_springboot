package com.organimaster.org.repository;

import com.organimaster.org.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query(value = "CALL sp_get_supplier()", nativeQuery = true)
    List<Object[]> retrieveIdAndSupplierName();
}
