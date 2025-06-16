package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product product) {
        productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>())
                .add(product);
    }

    public int getTotalCost() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printContents() {
        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        int totalItems = 0;

        List<Product> allProducts = productsMap.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Product::getName))
                .toList();

        for (Product p : allProducts) {
            System.out.println(p);
            if (p.isSpecial()) specialCount++;
            totalItems++;
        }

        System.out.println("Итого: " + getTotalCost() + " руб.");
        System.out.println("Товаров: " + totalItems);
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String name) {
        return productsMap.containsKey(name);
    }

    public void clearBasket() {
        productsMap.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = productsMap.remove(name);
        return removed != null ? removed : Collections.emptyList();
    }
}