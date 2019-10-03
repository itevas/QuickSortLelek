package com.lelek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ArrayGenerator {

    static int[] generate(int length) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list.stream().mapToInt(i -> i).toArray();
    }
}
