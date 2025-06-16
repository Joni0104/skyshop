package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchEngine {
    private final List<Searchable> items = new ArrayList<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public Map<String, Searchable> search(String query) {
        return items.stream()
                .filter(item -> item.getSearchTerm().contains(query))
                .collect(Collectors.toMap(
                        Searchable::getName,
                        item -> item,
                        (existing, replacement) -> existing
                        ));


    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            if (item == null) continue;

            int count = countOccurrences(item.getSearchTerm(), query);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(query);
        }
        return bestMatch;
    }

    private int countOccurrences(String text, String substring) {
        if (text.isEmpty() || substring.isEmpty()) return 0;

        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}


