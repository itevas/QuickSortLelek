package com.lelek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class ArrayGenerator {

    static int[] generate(int length, boolean unique) {
        if (unique) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                list.add(i);
            }
            Collections.shuffle(list);
            return list.stream().mapToInt(i -> i).toArray();
        } else {
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = new Random().nextInt(length);
            }
            return array;
        }
    }
}
