package edu.sliit.service;

import edu.sliit.dto.LowStockReport;

import java.util.List;

public interface ReportService {

    List<LowStockReport> getLowStockReport();
}
