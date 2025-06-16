package org.skypro.skyshop;

import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.content.SearchableComparator;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class App {
    public static void main(String[] args) {
        SearchEngine engine = getSearchEngine();

        System.out.println("Всего уникальных элементов: " + engine.size());


        System.out.println("Результаты поиска 'ноутбук':");
        Set<Searchable> results = engine.search("ноутбук");
        results.forEach(item ->
                System.out.println("- " + item.getName() +
                        " (длина: " + item.getName().length() + ")"));


        System.out.println("\nПроверка сортировки:");
        List<Searchable> testItems = Arrays.asList(
                new Article("Короткое"),
                new Article("Среднее название"),
                new Article("Очень длинное название статьи"),
                new Article("Среднее имя"),
                new Article("Еще одно название")
        );

        Set<Searchable> sortedSet = new TreeSet<>(new SearchableComparator());
        sortedSet.addAll(testItems);

        sortedSet.forEach(item ->
                System.out.println("- " + item.getName() +
                        " (длина: " + item.getName().length() + ")"));
    }

    private static SearchEngine getSearchEngine() {
        SearchEngine engine = new SearchEngine();


        Product laptop1 = new SimpleProduct("Ноутбук Lenovo", 50000);
        Product laptop2 = new SimpleProduct("Ноутбук Lenovo", 55000); // Дубликат
        Article review1 = new Article("Обзор новейших ноутбуков 2023 года");
        Article review2 = new Article("Сравнение ноутбуков и планшетов");
        Article review3 = new Article("Ноутбуки для работы");


        engine.add(laptop1);
        engine.add(laptop2);
        engine.add(review1);
        engine.add(review2);
        engine.add(review3);
        return engine;
    }
}