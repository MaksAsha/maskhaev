package ru.job4j.loop;

public class Board {

    public String paint(int width, int height) {
        StringBuilder sb = new StringBuilder();
        String ls = System.lineSeparator();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((i + j) % 2 != 0) {
                    sb.append(" ");
                } else {
                    sb.append("X");
                }
            }
            sb.append(ls);
        }
        return sb.toString();
    }
}
