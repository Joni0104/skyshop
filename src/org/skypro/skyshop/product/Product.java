package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String name;

    protected Product(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean match(String query) {
        return name.toLowerCase().contains(query.toLowerCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public abstract String getSearchTerm();
}