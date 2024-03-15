package com.shopping;

import com.shopping.model.ShoppingCartResult;
import com.shopping.repository.DefaultProductRepository;
import com.shopping.repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.shopping.factory.ProductFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {
    private static ProductRepository productRepository;
    private static ShoppingCart shoppingCart;


    @BeforeAll
    static void setup() {
        productRepository = new DefaultProductRepository();
        shoppingCart = new ShoppingCart(productRepository);

    }

    @DisplayName("Single quantity of each product test successful")
    @Test
    void testSingleProductSuccessTest() {
        List<String> productItems = Arrays.asList(APPLE, BANANA, MELON, LIME);
        ShoppingCartResult result = shoppingCart.calculateTotalPrice(productItems);

        assertEquals(120.0, result.getTotalCost());
    }

    @DisplayName("Buy One Get One Free test successful")
    @Test
    void testBuyOneGetOneFreeProductSuccessTest() {
        List<String> productItems = Arrays.asList(MELON, MELON);
        ShoppingCartResult result = shoppingCart.calculateTotalPrice(productItems);

        assertEquals(50.0, result.getTotalCost());
    }

    @DisplayName("Buy Three For Price Of Two test successful")
    @Test
    void testBuyThreeForPriceOfTwoProductSuccessTest() {
        List<String> productItems = Arrays.asList(LIME, LIME, LIME);
        ShoppingCartResult result = shoppingCart.calculateTotalPrice(productItems);

        assertEquals(30.0, result.getTotalCost());
    }

    @DisplayName("Mix quantity of each product with no-discount test successful")
    @Test
    void testMixProductSuccessTest() {
        List<String> productItems = Arrays.asList(APPLE, BANANA, APPLE, BANANA, MELON, LIME, LIME);
        ShoppingCartResult result = shoppingCart.calculateTotalPrice(productItems);

        assertEquals(190.0, result.getTotalCost());
    }

    @DisplayName("Mix quantity of each product with discount test successful")
    @Test
    void testMixProductDiscountSuccessTest() {
        List<String> productItems = Arrays.asList(APPLE, BANANA, APPLE, BANANA, MELON, MELON, LIME, LIME, LIME);
        ShoppingCartResult result = shoppingCart.calculateTotalPrice(productItems);

        assertEquals(190.0, result.getTotalCost());
    }

    @DisplayName("Empty product items test successful")
    @Test
    void testEmptyProductSuccessTest() {
        List<String> productItems = Collections.emptyList();
        ShoppingCartResult result = shoppingCart.calculateTotalPrice(productItems);

        assertEquals(0, result.getTotalCost());
    }

}
