package edu.sliit.service;

import edu.sliit.dto.Stock;

import java.util.List;

public interface StockService {
    void addStock(Stock stock);
    void reduceStock(Stock stock);

    List<Stock> getAll();

    Stock getStockById(Integer stockId);

    List<Stock> getStockByProductId(Integer productId);
}
