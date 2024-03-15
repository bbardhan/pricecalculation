package com.shopping.processor;

import com.shopping.model.Coupon;
import com.shopping.model.CouponProcessorInput;
import com.shopping.model.CouponProcessorResult;

public class BuyThreeForPriceOfTwoCouponProcessor implements CouponProcessor {

    private CouponProcessorInput input;

    public BuyThreeForPriceOfTwoCouponProcessor(CouponProcessorInput input) {
        this.input = input;
    }

    @Override
    public CouponProcessorResult applyCoupon(Coupon coupon) {
        long prodQtyInThreeMultiple = input.getProdQuantity() / 3;
        double totalDiscount = prodQtyInThreeMultiple * input.getProdPrice();
        double totalPrice = input.getProdQuantity() * input.getProdPrice() - totalDiscount;

        return CouponProcessorResult.builder().totalDiscount(totalDiscount).totalPrice(totalPrice).build();
    }
}
