package org.skypro.skyshop.content;

import org.skypro.skyshop.search.Searchable;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lengthCompare = Integer.compare(
                s2.getName().length(),
                s1.getName().length()
        );
        return lengthCompare != 0 ? lengthCompare :
                s1.getName().compareTo(s2.getName());
    }
}