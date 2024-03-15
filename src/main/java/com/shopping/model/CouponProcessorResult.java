package com.shopping.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouponProcessorResult {
    private double totalPrice;
    private double totalDiscount;
}
