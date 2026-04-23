package edu.sliit.Controller;

import edu.sliit.dto.Product;
import edu.sliit.service.ProductService;
import edu.sliit.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/get-all")
    public List<Product> getProduct(){

        return service.getProduct();
    }

    @PostMapping("/add-product")
    public void addProduct(@RequestBody Product product){

        service.addProduct(product);
    }
}
