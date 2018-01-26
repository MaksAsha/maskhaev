package ru.job4j.array;

public class BubbleSort {

    public int[] sort(int[] data) {
        int k;

        for (int j = 0; j < data.length - 1; j++) {
            for (int i = 0; i < data.length - 1 - j; i++) {
                if (data[i] > data[i + 1]) {
                    k = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = k;
                }
            }
        }
        return data;
    }

}
