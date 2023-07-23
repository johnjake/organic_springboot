package com.organimaster.org.repository;

import com.organimaster.org.model.Product;
import com.organimaster.org.utils.IterableUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class ProductRepositoryTest {
    @Autowired private ProductRepository productRepository;

    @Test
    public void addNewProduct() {
        Product product = new Product();
        product.setProductName("Green Apple");
        product.setCategoryId(1L);
        product.setDescription("Green Apple");
        product.setPrice(10.5);
        product.setStockQuantity(10);
        product.setOriginCountry("MY");
        product.setProductionDate(LocalDate.of(2023, 5, 5));
        product.setExpireDate(LocalDate.of(2023, 8, 12));
        product.setSupplierId(1L);

        Product saveProduct = productRepository.save(product);
        Assertions.assertEquals(saveProduct.getPrice(), 10.5);
    }

    @Test
    public void listAllProductTest() {
        var items = productRepository.findAll();
        var count = IterableUtils.countIterable(items);
        System.out.println(count);
        Assertions.assertTrue(count > 0);
    }

    @Test
    public void updateProductTest() {
        var productId = 1;
        var nameProduct = "Pineapple";
        var optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            var product = optionalProduct.get();
            product.setProductName(nameProduct);
            productRepository.save(product);
            var updatedProduct = productRepository.findById(productId).get();
            System.out.println("New Product Name: "+ updatedProduct.getProductName());
            Assertions.assertEquals(nameProduct, updatedProduct.getProductName());
        }
    }
}
