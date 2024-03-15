package com.shopping.factory;

import com.shopping.model.Coupon;
import com.shopping.model.CouponType;
import com.shopping.model.Product;

import static java.util.Objects.nonNull;

public interface ProductFactory {
    String APPLE = "Apple";
    String BANANA = "Banana";
    String MELON = "Melon";
    String LIME = "Lime";

    static Product createProduct(String name, double price) {
        return createProduct(name, price, null);
    }

    static Product createProduct(String name, double price, CouponType couponType) {
        Coupon coupon = null;
        if (nonNull(couponType)) {
            coupon = Coupon.builder().couponType(couponType).build();
        }
        return Product.builder().name(name).price(price).coupon(coupon).build();
    }

}
