package edu.sliit.service.impl;

import edu.sliit.dto.Product;
import edu.sliit.entity.ProductEntity;
import edu.sliit.repository.ProductRepository;
import edu.sliit.repository.StockRepository;
import edu.sliit.repository.SupplierRepository;
import edu.sliit.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final ProductRepository repository;
    final ModelMapper mapper;
    final StockRepository stockRepository;
    final SupplierRepository supplierRepository;

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

        boolean supplierExists = supplierRepository.existsBySupplierId(product.getSupplierId());

        if (!supplierExists) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Supplier ID not found"
            );
        }
        repository.save(mapper.map(product, ProductEntity.class));

    }

    @Override
    @Transactional
    public void deleteById(Integer productId) {

        stockRepository.deleteByProductId(productId);
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

    @Override
    public List<Product> searchBySupplierId(Integer supplierId) {
        List<Product> products = new ArrayList<>();
        repository.findBySupplierId(supplierId).forEach(entity ->{
            products.add(mapper.map(entity,Product.class));
        });
        return products;
    }

    @Override
    public long getProductCount() {
        return repository.count();
    }
}
