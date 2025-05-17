package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    String getName();

    default String getStringRepresentation(String discount) {
        return getName() + " - " + getContentType();
    }
}