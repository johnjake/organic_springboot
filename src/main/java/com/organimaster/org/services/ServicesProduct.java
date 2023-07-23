package com.organimaster.org.services;

import com.organimaster.org.model.Product;

import java.util.List;

public interface ServicesProduct {
    List<Product> listProduct();
    Product findProductId(int productId);
}
