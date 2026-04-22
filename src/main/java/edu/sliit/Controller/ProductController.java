package edu.sliit.Controller;

import edu.sliit.dto.Product;
import edu.sliit.service.ProductService;
import edu.sliit.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping
    public Product getProduct(){
        return service.getProduct();
    }
}
