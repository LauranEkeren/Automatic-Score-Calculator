package com.example.tinycalculator.Domain.Utils;

import java.util.Comparator;
import java.util.Set;

public class SizeComparator implements Comparator<Set<?>> {
    @Override
    public int compare(Set<?> o1, Set<?> o2) {
        return Integer.compare(o1.size(), o2.size());
    }
}
