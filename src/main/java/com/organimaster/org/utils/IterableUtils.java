package com.organimaster.org.utils;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IterableUtils {
    public static <T> int countIterable(Iterable<T> iterable) {
        int count = 0;
        for (T t : iterable) {
            count++;
        }
        return count;
    }

    public static  <T, K> HashMap<K, T> convertListToHashMap(List<T> list, Function<T, K> keyExtractor) {
        HashMap<K, T> map = new HashMap<>();
        for (T item : list) {
            K key = keyExtractor.apply(item);
            map.put(key, item);
        }
        return map;
    }

    public static <T> List<T> mapToObjectList(List<Object[]> dataList, Function<Object[], T> mappingFunction) {
        return dataList.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }
}
