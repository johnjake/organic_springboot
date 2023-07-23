package com.organimaster.org.services;

import com.organimaster.org.model.Product;
import com.organimaster.org.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices implements ServicesProduct {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> listProduct() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public Product findProductId(int productId) {
        var optionalProduct = repository.findById(productId);
        return optionalProduct.orElseGet(Product::new);
    }
}
