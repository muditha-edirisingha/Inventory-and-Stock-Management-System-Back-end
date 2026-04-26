package edu.sliit.repository;

import edu.sliit.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    List<ProductEntity> findByProductName(String productName);

    List<ProductEntity> findByProductId(Integer productId);
}
