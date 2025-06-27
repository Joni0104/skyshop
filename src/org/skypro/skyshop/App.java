package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;



import java.util.Set;



public class App {
    public static void main(String[] args) {

        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Ноутбук", 50000));
        engine.add(new DiscountedProduct("Смартфон", 30000, 10));
        engine.add(new FixPriceProduct("Зарядное устройство"));

        Set<Searchable> results = engine.search("ноутбук");
        System.out.println("Результаты поиска:");
        results.forEach(item -> System.out.println("- " + item.getName()));


        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Книга", 500));
        basket.addProduct(new DiscountedProduct("Мышь", 1000, 10));
        basket.addProduct(new FixPriceProduct("Флешка"));

        System.out.println("Содержимое корзины:");
        basket.printContents();
    }
}