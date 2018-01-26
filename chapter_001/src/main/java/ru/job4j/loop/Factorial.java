package ru.job4j.loop;

public class Factorial {

    public int calc(int n) throws IllegalArgumentException{
        int result = 1;

        if (n > 1) {
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
        } else {
            if (n < 0) throw new IllegalArgumentException();
            if ((n == 0) || (n == 1)) result = 1;
        }
        return result;
    }
}