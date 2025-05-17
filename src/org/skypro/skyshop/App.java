package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product simple = new SimpleProduct("Книга", 500);
        Product discounted = new DiscountedProduct("Мышь", 1000, 20);
        Product fixed = new FixPriceProduct("Флешка");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(simple);
        basket.addProduct(discounted);
        basket.addProduct(fixed);

        basket.printContents();
    }
}