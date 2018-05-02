public class LinearMotionEquations {
    /*
    x = x0 + vt (constant velocity)
    v = v0 + at (constant acceleration)
    x = x0 + v0t + 1/2 at^2
    v^2 = v0^2 + 2a(x - x0)
     */

    static double x(double x0, double vf, double t) {
        return x0 + vf * t;
    }

    static double x(double x0, double v0, double a, double t) {
        double first = x0;
        double second = v0 * t;
        double third = 0.5 * a * t * t;

        return first + second + third;
    }

    static double v(double v0, double a, double t) {
        return v0 + a * t;
    }

    /**
     * v = sqrt(v0^2 + 2a(deltaX))
     * NOTE: Only gives magnitude, no direction
     *
     * @param v0
     * @param a
     * @param deltaX
     * @return
     */
    static double vMagnitude(double v0, double a, double deltaX) {
        double vSquared = v0 * v0 + 2 * a * deltaX;
        return Math.sqrt(vSquared);
    }

    /**
     * 1/2 at^2 + v0t - deltaX = 0
     *
     * @param v0
     * @param a
     * @param deltaX
     * @return
     */
    static double t(double v0, double a, double deltaX) {
        a = 0.5 * a;
        double b = v0;
        double c = -deltaX;
        return solveForPositiveRoot(a, b, c);
    }

    /**
     * Solves a quadratic equation in the form of:
     * ax^2 + bx + c = 0
     * using the quadratic formula:
     * (-b+sqrt(b^2-4ac))/2a
     * NOTE: only returns the positive root
     *
     * @param a
     * @param b
     * @param c
     * @return positive root
     */
    private static double solveForPositiveRoot(double a, double b, double c) {
        double numPos = -b + Math.sqrt(b * b - 4 * a * c);
        double numNeg = -b - Math.sqrt(b * b - 4 * a * c);
        return numPos > numNeg ? numPos : numNeg;
    }
}