package edu.sliit.service;

import edu.sliit.dto.Product;
import edu.sliit.entity.ProductEntity;
import edu.sliit.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    final ProductRepository repository;
    final ModelMapper mapper;

    @Override
    public  List<Product> getProduct() {
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(product->{
            products.add(mapper.map(product, Product.class));

        });
        return products;
    }

    @Override
    public void addProduct(Product product) {
        repository.save(mapper.map(product, ProductEntity.class));


    }
}
