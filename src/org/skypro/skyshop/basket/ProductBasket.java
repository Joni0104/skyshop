package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalCost() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printContents() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        for (Product p : products) {
            System.out.println(p);
            if (p.isSpecial()) specialCount++;
        }

        System.out.println("Итого: " + getTotalCost() + " руб.");
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String name) {
        return products.stream()
                .anyMatch(p -> p.getName().equals(name));
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equals(name)) {
                removed.add(p);
                iterator.remove();
            }
        }

        return removed;
    }
}
