package com.shopping.model;

public enum CouponType {
    BUY_ONE_GET_ONE_FREE("buy1Get1Free"), THREE_FOR_THE_PRICE_OF_TWO("3ForPriceOf2");

    private String value;

    CouponType(String value) {
        this.value = value;
    }
}
