package ru.job4j.max;

/**
 * @author Maksim Askhaev (maksim.askhaev@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Возвращает максимальное значение
     *
     * @param first  - целое число int
     * @param second - целое число int
     * @return максимальное их двух параметров
     */
    public int getMax(int first, int second) {
        return first > second ? first : second;
    }
}
