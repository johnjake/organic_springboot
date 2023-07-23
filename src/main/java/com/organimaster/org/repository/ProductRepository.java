package com.organimaster.org.repository;

import com.organimaster.org.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
