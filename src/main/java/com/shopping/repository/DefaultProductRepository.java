package com.shopping.repository;

import com.shopping.model.Product;

import java.util.HashMap;
import java.util.Map;

import static com.shopping.factory.ProductFactory.*;
import static com.shopping.model.CouponType.BUY_ONE_GET_ONE_FREE;
import static com.shopping.model.CouponType.THREE_FOR_THE_PRICE_OF_TWO;

public class DefaultProductRepository implements ProductRepository {
    private static final Map<String, Product> productMap = new HashMap<>();

    static {
        productMap.put(APPLE, createProduct(APPLE, 35));
        productMap.put(BANANA, createProduct(BANANA, 20));
        productMap.put(MELON, createProduct(MELON, 50, BUY_ONE_GET_ONE_FREE));
        productMap.put(LIME, createProduct(LIME, 15, THREE_FOR_THE_PRICE_OF_TWO));
    }

    @Override
    public Map<String, Product> productMap() {
        return Map.copyOf(productMap);
    }

}

