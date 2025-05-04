package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Книга", 500);
        Product product2 = new Product("Мышь", 1000);
        Product product3 = new Product("Ноутбук", 50000);
        Product product4 = new Product("Флешка", 800);
        Product product5 = new Product("Наушники", 2000);
        Product product6 = new Product("Клавиатура", 1500);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        System.out.println("Содержимое корзины:");
        basket.printContents();

        System.out.println("Общая стоимость: " + basket.getTotalCost());

        System.out.println("Есть ли 'Мышь'? " + basket.containsProduct("Мышь"));
        System.out.println("Есть ли 'Стол'? " + basket.containsProduct("Стол"));

        basket.clearBasket();
        System.out.println("После очистки:");
        basket.printContents();

        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost());
        System.out.println("Есть ли 'Мышь' теперь? " + basket.containsProduct("Мышь"));
    }
}