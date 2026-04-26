package edu.sliit.service;

import edu.sliit.dto.Product;

import java.util.List;

public interface ProductService  {
    List<Product> getProduct();
    void addProduct(Product product);

    void deleteById(Integer productId);

    List<Product> searchByProductName(String productName);

    List<Product> searchByProductId(Integer productId);
}
