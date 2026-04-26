package edu.sliit.Controller;

import edu.sliit.dto.Product;
import edu.sliit.service.ProductService;
import edu.sliit.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product){

        service.addProduct(product);
    }

    @DeleteMapping("/delete-by-id/{productId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable Integer productId){
        service.deleteById(productId);
    }

    @PutMapping("/update-product")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@RequestBody Product product){

        service.addProduct(product);
    }

    @GetMapping("/search-by-name/{productName}")
    public List<Product> searchByName(@PathVariable String productName){

        return service.searchByProductName(productName);
    }

    @GetMapping("/search-by-productId/{productId}")
    public List<Product> searchByProductId(@PathVariable Integer productId){

        return service.searchByProductId(productId);
    }
}
