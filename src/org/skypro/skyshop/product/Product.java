package org.skypro.skyshop.product;
import org.skypro.skyshop.search.Searchable;
public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }

    public abstract String getStringRepresentation();

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}

