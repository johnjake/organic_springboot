package com.organimaster.org.controller;

import com.organimaster.org.model.Product;
import com.organimaster.org.services.ServicesProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Order(2)
public class ProductController {
    @Autowired private ServicesProduct services;
    @GetMapping("/products")
    public String showProductList(Model model) {
        List<Product> listProduct = services.listProduct();
        model.addAttribute("listProduct", listProduct);
        return "products";
    }
}
