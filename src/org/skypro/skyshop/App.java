package org.skypro.skyshop;

import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;



public class App {
    public static void main(String[] args) {

        try {
            Product invalid1 = new SimpleProduct("  ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }

        try {
            Product invalid2 = new DiscountedProduct("Телефон", -5000, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }


        SearchEngine engine = createSearchEngine();

        try {
            Searchable best = engine.findBestMatch("ноутбук");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            engine.findBestMatch("несуществующий запрос");
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }

    private static SearchEngine createSearchEngine() {
        SearchEngine engine = new SearchEngine(10);
        engine.add(new SimpleProduct("Ноутбук игровой", 100000));
        engine.add(new Article("Обзоры ноутбуков", "Лучшие ноутбуки 2023..."));
        return engine;
    }
}