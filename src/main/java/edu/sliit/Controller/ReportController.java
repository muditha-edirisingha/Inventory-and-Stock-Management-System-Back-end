package edu.sliit.Controller;

import edu.sliit.dto.LowStockReport;
import edu.sliit.dto.StockHistoryReport;
import edu.sliit.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {
    final ReportService reportService;
    @GetMapping("/get-low-stock-report")
    public List<LowStockReport> getLowStockReport(){
        return reportService.getLowStockReport();
    }

    @GetMapping("/get-stock-history")
    public List<StockHistoryReport> getStockHistory(){
        return reportService.getStockHistoryReport();
    }

    @GetMapping("/get-stock-history-by-id/{productId}")
    public List<StockHistoryReport> getStockHistoryById(@PathVariable Integer productId){
        return reportService.getStockHistoryByProductId(productId);
    }
}
