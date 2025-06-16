package org.skypro.skyshop.search;

import org.skypro.skyshop.content.SearchableComparator;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> items = new HashSet<>();
    private final Comparator<Searchable> comparator = new SearchableComparator();

    public void add(Searchable item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    public Set<Searchable> search(String query) {
        if (query == null) {
            throw new IllegalArgumentException("Query cannot be null");
        }

        Set<Searchable> result = new TreeSet<>(comparator);
        for (Searchable item : items) {
            if (item.match(query)) {
                result.add(item);
            }
        }
        return result;
    }

    public int size() {
        return items.size();
    }
}