package com.shopping.processor;

import com.shopping.model.Coupon;
import com.shopping.model.CouponProcessorInput;
import com.shopping.model.CouponProcessorResult;

public class BuyOneGetOneFreeCouponProcessor implements CouponProcessor {

    private CouponProcessorInput input;

    public BuyOneGetOneFreeCouponProcessor(CouponProcessorInput input) {
        this.input = input;
    }

    @Override
    public CouponProcessorResult applyCoupon(Coupon coupon) {
        long prodQtyInTwoMultiple = input.getProdQuantity() / 2;
        double totalDiscount = prodQtyInTwoMultiple * input.getProdPrice();
        double totalPrice = input.getProdQuantity() * input.getProdPrice() - totalDiscount;
        return CouponProcessorResult.builder().totalDiscount(totalDiscount).totalPrice(totalPrice).build();
    }
}
