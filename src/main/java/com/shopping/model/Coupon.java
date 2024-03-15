package com.shopping.model;

import lombok.*;

@Builder
@Data
public class Coupon {
    private CouponType couponType;
    private double couponAmount;
}
