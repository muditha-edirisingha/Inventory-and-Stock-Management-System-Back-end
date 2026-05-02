package edu.sliit.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LowStockReport {
    private Integer productId;
    private String productName;
    private String description;
    private int currentQty;
    private String status;
}
