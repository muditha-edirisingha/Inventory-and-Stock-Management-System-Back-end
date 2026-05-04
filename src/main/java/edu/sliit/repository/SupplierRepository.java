package edu.sliit.repository;

import edu.sliit.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierEntity,Integer> {
    List<SupplierEntity> findBysupplierName(String supplierName);

    List<SupplierEntity> findBysupplierId(Integer supplierId);
}
