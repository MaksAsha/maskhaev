package ru.job4j.array;

public class Turn {

    public int[] back(int[] data) {
        int k;
        for (int i = 0; i < data.length / 2; i++) {
            k = data[i];
            data[i] = data[data.length - i - 1];
            data[data.length - i - 1] = k;
        }
        return data;
    }
}
