package com.shopping.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouponProcessorInput {
    private double prodPrice;
    private long prodQuantity;
}

