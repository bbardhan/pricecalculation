package com.shopping.factory;

import com.shopping.processor.BuyOneGetOneFreeCouponProcessor;
import com.shopping.processor.BuyThreeForPriceOfTwoCouponProcessor;
import com.shopping.model.Coupon;
import com.shopping.model.CouponProcessorInput;
import com.shopping.processor.CouponProcessor;

public interface CouponProcessorFactory {

    static CouponProcessor getCouponProcessor(Coupon coupon, CouponProcessorInput input) {
        switch (coupon.getCouponType()) {
            case BUY_ONE_GET_ONE_FREE -> {
                return new BuyOneGetOneFreeCouponProcessor(input);
            }
            case THREE_FOR_THE_PRICE_OF_TWO -> {
                return new BuyThreeForPriceOfTwoCouponProcessor(input);
            }
            default -> {
                throw new UnsupportedOperationException("Invalid couponType " + coupon.getCouponType());
            }
        }
    }
}
