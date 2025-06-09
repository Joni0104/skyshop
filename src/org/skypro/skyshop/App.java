package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();


        basket.addProduct(new SimpleProduct("Книга", 500));
        basket.addProduct(new DiscountedProduct("Мышь", 1000, 20));
        basket.addProduct(new FixPriceProduct("Флешка"));
        basket.addProduct(new SimpleProduct("Книга", 300));

        System.out.println("Содержимое корзины:");
        basket.printContents();


        System.out.println("Удаление товара 'Книга':");
        List<Product> removed = basket.removeProductsByName("Книга");
        System.out.println("Удалено " + removed.size() + " товаров:");
        removed.forEach(p -> System.out.println("- " + p.getName()));

        System.out.println("Содержимое корзины после удаления:");
        basket.printContents();


        SearchEngine engine = new SearchEngine();
        engine.add(new SimpleProduct("Ноутбук", 75000));
        engine.add(new Article("Обзор ноутбуков", "Лучшие модели 2023"));
        engine.add(new DiscountedProduct("Игровая мышь", 2500, 15));
        engine.add(new SimpleProduct("Мышь беспроводная", 1200));

        System.out.println("Результаты поиска 'мышь':");
        Map<String, Searchable> results = engine.search("мышь");
        results.forEach((name, item) ->
                System.out.println(name + ": " + item.getStringRepresentation()));
    }
}