package edu.sliit.repository;

import edu.sliit.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity,Integer> {

    List<StockEntity> findByProductId(Integer productId);
}
