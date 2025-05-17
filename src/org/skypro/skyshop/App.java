package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Создание объектов
        Product[] products = {
                new SimpleProduct("Книга Java", 500),
                new DiscountedProduct("Мышь игровая", 1000, 20),
                new FixPriceProduct("USB-флешка")
        };

        Article[] articles = {
                new Article("Обзор мышей", "Лучшие игровые мыши 2025 года..."),
                new Article("Java для начинающих", "Основы программирования на Java...")
        };

        // Создание поискового движка
        SearchEngine engine = new SearchEngine(10);
        for (Product p : products) engine.add(p);
        for (Article a : articles) engine.add(a);

        // Демонстрация поиска
        System.out.println("Результаты поиска 'Java':");
        System.out.println(Arrays.toString(engine.search("Java")));

        System.out.println("Результаты поиска 'мыш':");
        System.out.println(Arrays.toString(engine.search("мыш")));
    }
}