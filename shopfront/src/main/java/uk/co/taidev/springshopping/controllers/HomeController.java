package uk.co.taidev.springshopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import uk.co.taidev.springshopping.model.Product;
import uk.co.taidev.springshopping.services.ProductService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "index";
    }
}
