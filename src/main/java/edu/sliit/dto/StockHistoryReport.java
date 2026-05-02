package edu.sliit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockHistoryReport {
    private Integer stockId;
    private Integer productId;
    private String productName;
    private Integer quntityAdded;
    private Integer quntityRemoved;
    private Integer currentQuntity;
    private LocalDateTime dateTime;
    private String stockType;
}