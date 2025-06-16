package org.skypro.skyshop.content;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String name;

    public Article(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }

    @Override
    public String getSearchTerm() {
        return "";
    }

    @Override
    public String getContentType() {
        return "";
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
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return name.equals(article.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}