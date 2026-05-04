package edu.sliit.Controller;

import edu.sliit.dto.Stock;
import edu.sliit.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    final StockService stockService;
    @PostMapping("/add-stock")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStock(@RequestBody Stock stock){

        stockService.addStock(stock);
    }


    @PostMapping("/reduce-stock")
    @ResponseStatus(HttpStatus.CREATED)
    public void reduceStock(@RequestBody Stock stock){
        stockService.reduceStock(stock);
    }


    @GetMapping("/get-all-stocks")
    public List<Stock> getAll(){
        return stockService.getAll();
    }

    @GetMapping("/get-stock-by-id/{stockId}")
    public Stock getStockById(@PathVariable Integer stockId){
        return stockService.getStockById(stockId);
    }

    @GetMapping("/get-stock-by-product-id/{productId}")
    public List<Stock> getStockByProductId(@PathVariable Integer productId){
        return stockService.getStockByProductId(productId);
    }
}
