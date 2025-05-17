package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] searchables;
    private int size;

    public SearchEngine(int capacity) {
        searchables = new Searchable[capacity];
    }

    public void add(Searchable item) {
        if (size < searchables.length) {
            searchables[size++] = item;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().contains(query)) {
                results[count++] = item;
                if (count == 5) break;
            }
        }
        return results;
    }
}
