package edu.sliit.service.impl;

import edu.sliit.dto.LowStockReport;
import edu.sliit.repository.ProductRepository;
import edu.sliit.repository.StockRepository;
import edu.sliit.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    final ProductRepository productRepository;
    final StockRepository stockRepository;


    @Override
    public List<LowStockReport> getLowStockReport() {
        List<LowStockReport> reportList = new ArrayList<>();

        int LOW_STOCK_THRESHOLD = 10;   // 🔥 simple fixed value

        productRepository.findAll().forEach(product -> {

            if (product.getQty() <= LOW_STOCK_THRESHOLD) {

                LowStockReport report = new LowStockReport();

                report.setProductId(product.getProductId());
                report.setProductName(product.getProductName());
                report.setDescription(product.getDescription());
                report.setCurrentQty(product.getQty());

                if (product.getQty() == 0) {
                    report.setStatus("OUT OF STOCK");
                } else {
                    report.setStatus("LOW STOCK");
                }

                reportList.add(report);
            }
        });

        return reportList;
    }
}
