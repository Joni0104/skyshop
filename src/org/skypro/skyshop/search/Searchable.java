package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();

    String getContentType();
    String getName();
    boolean match(String query);
    default String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }
}