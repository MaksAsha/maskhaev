package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {

    public String[] remove(String[] data) {
        int k1 = data.length;

        for (int i = 0; i < k1; i++) {
            for (int j = i + 1; j < k1; j++) {
                if (data[i].equals(data[j])) {
                    data[j] = data[k1 - 1];
                    k1--;
                    j--;
                }
            }
        }

        return Arrays.copyOf(data, k1);
    }

}
