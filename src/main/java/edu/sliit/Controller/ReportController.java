package edu.sliit.Controller;

import edu.sliit.dto.LowStockReport;
import edu.sliit.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {
    final ReportService reportService;
    @GetMapping("/get-low-stock-report")
    public List<LowStockReport> getLowStockReport(){
        return reportService.getLowStockReport();
    }

}
