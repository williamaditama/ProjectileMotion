public class Vector {
    double x, y;

    /**
     * Default constructor that creates a Vector of magnitude 0
     */
    Vector() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Vector with x and y components
     * @param x x-component
     * @param y y-component
     */
    Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Vector with magnitude and angle
     * @param magnitude
     * @param angle
     */
    Vector(double magnitude, Angle angle) {
        this.y = magnitude * Math.sin(angle.toRad());
        this.x = magnitude * Math.cos(angle.toRad());
    }

    /**
     * Multiply the vector by a scalar
     * @param c the scalar to multiply
     * @return cA
     */
    Vector scalarMultiple(double c) {
        return new Vector(x * c, y * c);
    }

    /**
     * Add two vectors together (A+B)
     * @param b Vector B
     * @return (A+B)
     */
    Vector add(Vector b) {
        return new Vector(this.x + b.x, this.y + b.y);
    }

    /**
     * Changes the vector to the opposite direction
     * @return -A
     */
    Vector negate() {
        return new Vector(-this.x, -this.y);
    }

    /**
     * Gets the magnitude of the vector
     * @return |A|
     */
    double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Gets the angle in degrees with respect to the right horizontal
     * anti-clockwise being the positive direction
     * @return theta with respect to the horizontal
     */
    double angleDegrees() {
        double alpha = (Math.atan(Math.abs(y) / Math.abs(x))) * (180 / Math.PI);

        if (x > 0 && y > 0) return alpha;
        if (x < 0 && y > 0) return 180 - alpha;
        if (x < 0 && y < 0) return 180 + alpha;
        if (x > 0 && y < 0) return -alpha;
        return 0;
    }
}

/**
 * An angle object, in order to distinguish
 * the two constructors in the Vector class
 */
class Angle {
    double angle;

    /**
     * Initialize an angle in degrees
     * @param degrees
     */
    public Angle(double degrees) {
        this.angle = degrees;
    }

    /**
     * Convert to Radians
     * @return
     */
    public double toRad() {
        return angle * (Math.PI / 180);
    }
}
