package com.shopping.repository;

import com.shopping.model.Product;

import java.util.Map;

public interface ProductRepository {
    Map<String, Product> productMap();
}
