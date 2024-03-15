package com.shopping;

import com.shopping.factory.CouponProcessorFactory;
import com.shopping.model.*;
import com.shopping.processor.CouponProcessor;
import com.shopping.repository.ProductRepository;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Log
public class ShoppingCart {

    private ProductRepository productRepository;

    public ShoppingCart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ShoppingCartResult calculateTotalPrice(List<String> productItems) {
        ShoppingCartResult result = ShoppingCartResult.builder().totalCost(0).build();

        if (isNull(productItems) || productItems.isEmpty()) {
            log.info("Product items is empty");
            return result;
        }

        double totalCost = 0;
        Map<String, Product> productStore = productRepository.productMap();

        Map<String, Long> productItemMap = productItems.stream().collect(groupingBy(String::toString, counting()));

        for (Map.Entry<String, Long> mapEntry : productItemMap.entrySet()) {
            Product product = productStore.get(mapEntry.getKey());
            if (isNull(product)) {
                log.info("The Product item is not found in our inventory : " + mapEntry.getKey());
                continue;
            }
            Long prodQuantity = mapEntry.getValue();
            Coupon coupon = product.getCoupon();

            if (nonNull(coupon) && nonNull(coupon.getCouponType())) {
                CouponProcessorInput input = CouponProcessorInput.builder().prodPrice(product.getPrice()).prodQuantity(prodQuantity).build();
                CouponProcessor couponProcessor = CouponProcessorFactory.getCouponProcessor(coupon, input);
                CouponProcessorResult couponResult = couponProcessor.applyCoupon(coupon);
                totalCost += couponResult.getTotalPrice();
            } else {
                totalCost += product.getPrice() * prodQuantity;
            }
        }

        result.setTotalCost(totalCost);
        return result;
    }

}
