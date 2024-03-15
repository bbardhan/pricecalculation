package com.shopping.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {
    private String name;
    private double price;
    private String currency = "GBP";
    private Coupon coupon;
}
