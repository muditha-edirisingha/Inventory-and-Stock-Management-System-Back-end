package edu.sliit.service.impl;

import edu.sliit.dto.Product;
import edu.sliit.dto.Stock;
import edu.sliit.dto.Supplier;
import edu.sliit.entity.SupplierEntity;
import edu.sliit.repository.SupplierRepository;
import edu.sliit.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{
    final ModelMapper mapper;
    final SupplierRepository repository;
    @Override
    public void addSupplier(Supplier supplier) {
        repository.save(mapper.map(supplier, SupplierEntity.class));
    }

    @Override
    public Boolean deletebyId(Integer supplierId) {
        repository.deleteById(supplierId);
        return true;
    }

    @Override
    public List<Supplier> getAll(){

        List<Supplier> suppliersList = new ArrayList<>();
        repository.findAll().forEach(entity ->{
            suppliersList.add(mapper.map(entity,Supplier.class));
        });
        return suppliersList;
    }

    @Override
    public List<Supplier> searchBysupplierName(String supplierName) {
        List<Supplier> suppliers = new ArrayList<>();
        repository.findBysupplierName(supplierName).forEach(entity ->{
            suppliers.add(mapper.map(entity,Supplier.class));
        });
        return suppliers;
    }

    @Override
    public List<Supplier> searchBysupplierId(Integer supplierId) {
        List<Supplier> suppliers = new ArrayList<>();
        repository.findBysupplierId(supplierId).forEach(entity ->{
            suppliers.add(mapper.map(entity,Supplier.class));
        });
        return suppliers;
    }
}
