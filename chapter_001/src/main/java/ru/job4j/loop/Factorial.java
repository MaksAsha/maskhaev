package ru.job4j.loop;

public class Factorial {

    public int calc(int n) throws IllegalArgumentException {
        int result = 1;

        if (n < 0) throw new IllegalArgumentException();

        for (int i = 1; i <= n; i++) {
            result = result * i;
        }

        return result;
    }
}
