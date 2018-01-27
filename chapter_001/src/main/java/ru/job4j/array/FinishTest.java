package ru.job4j.array;

public class FinishTest {

    public boolean contains(String origin, String sub) {

        int k;
        boolean found = false;
        char[] c_origin = origin.toCharArray();
        char[] c_sub = sub.toCharArray();
        int len = sub.length();

        for (int i = 0; i < c_origin.length - len + 1; i++) {
            k = 0;
            for (int j = 0; j < c_sub.length; j++) {
                if (c_origin[i + j] == c_sub[j]) {
                    k++;
                }
            }
            if (k == c_sub.length) {
                found = true;
                break;
            }
        }
        return found;
    }
}
