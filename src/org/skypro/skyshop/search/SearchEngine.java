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
    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchables) {
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


