package edu.sliit.service;
import java.util.List;

import edu.sliit.dto.Product;
import edu.sliit.dto.Supplier;

public interface SupplierService {
    void addSupplier(Supplier supplier);

    Boolean deletebyId(Integer supplierId);

    List<Supplier> getAll();

    List<Supplier> searchBysupplierName(String supplierName);

    List<Supplier> searchBysupplierId(Integer supplierId);
}
