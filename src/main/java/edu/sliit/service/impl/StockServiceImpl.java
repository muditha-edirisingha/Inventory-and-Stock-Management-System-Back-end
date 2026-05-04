package edu.sliit.service.impl;

import edu.sliit.dto.Stock;
import edu.sliit.entity.ProductEntity;
import edu.sliit.entity.StockEntity;
import edu.sliit.repository.ProductRepository;
import edu.sliit.repository.StockRepository;
import edu.sliit.service.StockService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    final StockRepository repository;
    final ModelMapper mapper;
    final ProductRepository productRepository;

    @Override
    public void addStock(Stock stock) {

        ProductEntity product = productRepository.findById(stock.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        int currentQty = product.getQty();
        int addedQty = stock.getQuntityAdded() == null ? 0 : stock.getQuntityAdded();

        if (addedQty <= 0) {
            throw new RuntimeException("Added quantity must be greater than 0");
        }

        int newQty = currentQty + addedQty;

        product.setQty(newQty);
        productRepository.save(product);

        stock.setQuntityAdded(addedQty);
        stock.setQuntityRemoved(0);
        stock.setCurrentQuntity(newQty);
        stock.setDateTime(LocalDateTime.now());

        repository.save(mapper.map(stock, StockEntity.class));
    }

    @Override
    public void reduceStock(Stock stock) {

        ProductEntity product = productRepository.findById(stock.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        int currentQty = product.getQty();
        int removedQty = stock.getQuntityRemoved() == null ? 0 : stock.getQuntityRemoved();

        if (removedQty <= 0) {
            throw new RuntimeException("Removed quantity must be greater than 0");
        }

        if (removedQty > currentQty) {
            throw new RuntimeException("Not enough stock available");
        }

        int newQty = currentQty - removedQty;

        product.setQty(newQty);
        productRepository.save(product);

        stock.setQuntityAdded(0);
        stock.setQuntityRemoved(removedQty);
        stock.setCurrentQuntity(newQty);
        stock.setDateTime(LocalDateTime.now());

        repository.save(mapper.map(stock, StockEntity.class));



    }


    @Override
    public List<Stock> getAll() {
        List<Stock> stockList = new ArrayList<>();
        repository.findAll().forEach(entity ->{
            stockList.add(mapper.map(entity,Stock.class));
        });
        return stockList;
    }

    @Override
    public Stock getStockById(Integer stockId) {

        return mapper.map(repository.findById(stockId),Stock.class);
    }

    @Override
    public List<Stock> getStockByProductId(Integer productId) {
        List<Stock> stockList = new ArrayList<>();
        repository.findByProductId(productId).forEach(entity ->{


           stockList.add(mapper.map(entity,Stock.class));

        });

        return stockList;
    }
}
