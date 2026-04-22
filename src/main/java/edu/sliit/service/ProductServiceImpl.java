package edu.sliit.service;

import edu.sliit.dto.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public Product getProduct() {
        return new Product(
                001,
                "Jam",
                "tasty",
                250.00,
                100
        );
    }
}
