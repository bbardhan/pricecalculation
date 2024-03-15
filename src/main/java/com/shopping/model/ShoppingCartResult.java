package com.shopping.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShoppingCartResult {
    private double totalCost;
    private String currency = "GBP";
}
