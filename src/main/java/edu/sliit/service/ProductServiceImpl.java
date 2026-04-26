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

    @Override
    public void deleteById(Integer productId) {
        repository.deleteById(productId);
    }

    @Override
    public List<Product> searchByProductName(String productName) {
        List<Product> products = new ArrayList<>();
        repository.findByProductName(productName).forEach(entity ->{
            products.add(mapper.map(entity,Product.class));
        });
        return products;
    }

    @Override
    public List<Product> searchByProductId(Integer productId) {
        List<Product> products = new ArrayList<>();
        repository.findByProductId(productId).forEach(entity ->{
            products.add(mapper.map(entity,Product.class));
        });
        return products;
    }
}
