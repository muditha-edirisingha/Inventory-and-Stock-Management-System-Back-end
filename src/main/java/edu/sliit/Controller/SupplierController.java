package edu.sliit.Controller;

import edu.sliit.dto.Supplier;
import edu.sliit.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {
    final SupplierService service;
    @PostMapping("/add-supplier")
    public void addSupplier(@RequestBody Supplier supplier){
        service.addSupplier(supplier);
    }

    @PutMapping("/update-supplier")
    public void updateSupplier(@RequestBody Supplier supplier){
        service.addSupplier(supplier);
    }

    @DeleteMapping("/delete-supplier/{supplierId}")
    public Boolean deleteSupplier(@PathVariable Integer supplierId){
        return service.deletebyId(supplierId);
    }

    @GetMapping("/get-all-suppliers")
    public List<Supplier> getAll(){
        return service.getAll();
    }

    @GetMapping("/search-by-name/{supplierName}")
    public List<Supplier> searchByName(@PathVariable String supplierName){

        return service.searchBysupplierName(supplierName);
    }
    @GetMapping("/search-by-id/{supplierId}")
    public List<Supplier> searchByName(@PathVariable Integer supplierId){

        return service.searchBysupplierId(supplierId);
    }
}
