package com.shopping.processor;

import com.shopping.model.Coupon;
import com.shopping.model.CouponProcessorResult;

public interface CouponProcessor {
    CouponProcessorResult applyCoupon (Coupon coupon);
}
