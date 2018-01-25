package ru.job4j.condition;

/**
 * Calculate triangle square
 *
 * @author Maksim Askhaev (maksim.askhaev@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Method calcSquare.
     * Рассчитывает площадь треугольника
     *
     * @return площадь треугольника
     */
    public double calcSquare() {
        double s = -1L;
        double ab = a.distanceTo(b);
        double bc = b.distanceTo(c);
        double ac = a.distanceTo(c);

        if (isTriangle(ab, bc, ac)) {
            double p = (ab + bc + ac) / 2L;
            s = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }

        return s;
    }

    /**
     * Method isTriangle.
     * Исключаем вырожденные случаи (по условию задачи)
     *
     * @param a,b,c - длины сторон треугольника.
     * @return является ли треугольник вырожденным
     */
    private boolean isTriangle(double a, double b, double c) {
        boolean result = false;
        if ((a < b + c) && (b < a + c) && (c < a + b)) {
            result = true;
        }

        return result;
    }
}
