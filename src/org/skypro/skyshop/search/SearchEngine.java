package org.skypro.skyshop.search;

import org.skypro.skyshop.content.SearchableComparator;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> items = new HashSet<>();
    private final Comparator<Searchable> comparator = new SearchableComparator();

    public void add(Searchable item) {
        items.add(item);
    }

    public Set<Searchable> search(String query) {
        return items.stream()
                .filter(item -> item.match(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }
}