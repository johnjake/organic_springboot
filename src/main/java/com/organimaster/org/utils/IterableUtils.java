package com.organimaster.org.utils;

import java.util.Iterator;

public class IterableUtils {
    public static <T> int countIterable(Iterable<T> iterable) {
        int count = 0;
        for (T t : iterable) {
            count++;
        }
        return count;
    }
}
