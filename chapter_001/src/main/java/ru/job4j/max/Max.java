package ru.job4j.max;

/**
 * @author Maksim Askhaev (maksim.askhaev@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Возвращает максимальное значение из двух операндов
     *
     * @param first  - целое число int
     * @param second - целое число int
     * @return максимальное их двух параметров
     */
    public int getMax(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Возвращает максимальное значение из трех операндов
     *
     * @param first  - целое число int
     * @param second - целое число int
     * @param third  - целое число int
     * @return максимальное их двух параметров
     */
    public int getMaxFromThree(int first, int second, int third) {
        return getMax(first, getMax(second, third));
    }
}
