package com.organimaster.org.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private HttpServletRequest request;
    @GetMapping("/index")
    public String index() {
        var cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) {
                    String accessToken = cookie.getValue();
                    return "index";
                }
            }
        }
        return "index";
    }
    @GetMapping( "/api/v1/management/shop-grid")
    public String shopGridList() {
        return "shop-details";
    }
    @GetMapping( "/shop-details")
    public String navigateToShopDetails() {
        return "shop-details";
    }

    @GetMapping(value = "/shoping-cart")
    public String navigateToShoppingCart() {
        return "shoping-cart";
    }

    @GetMapping(value = "/checkout", produces = "text/html")
    public String navigateToCheckout() {
        return "checkout";
    }

    @GetMapping(value = "/blog-details", produces = "text/html")
    public String navigateToBlogDetails() {
        return "blog-details";
    }

    @GetMapping(value = "/blog")
    public String blog() {

        return "blog";
    }

    @GetMapping(value = "/contact", produces = "text/html")
    public String navigateToContact() {
        return "contact";
    }

    @GetMapping(value = "/add-products", produces = "text/html")
    public String navigateToAddProduct() {
        return "add-products";
    }

    @GetMapping(value = "/sign-in", produces = "text/html")
    public String navigateToLogin() {
        return "sign-in";
    }

    @GetMapping(value = "/sign-up", produces = "text/html")
    public String navigateToSignUp() {
        return "sign-up";
    }
}
