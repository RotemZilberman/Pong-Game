/**
 * @author Rotem Zilberman 213231418
 * @version 1
 * @since 2022-03-20
 */

/**
 * This is the Velocity class.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Gets dx and dy speeds and return the Velocity object.
     *
     * @param dx is the dx speed.
     * @param dy is the dy speed.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * return the dx speed of the velocity.
     *
     * @return the dx speed of the velocity.
     */
    public double getDx() {
        return dx;
    }

    /**
     * return the dy speed of the velocity.
     *
     * @return the dy speed of the velocity.
     */
    public double getDy() {
        return dy;
    }

    /**
     * return the speed of the velocity.
     *
     * @return the speed of the velocity.
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(this.getDx(), 2) + Math.pow(this.getDy(), 2));
    }

    /**
     * the function turn the dx speed.
     */
    public void changeDx() {
        this.dx *= -1;
    }

    /**
     * the function turn the dy speed.
     */
    public void changeDy() {
        this.dy *= -1;
    }

    /**
     * the function gets a point and return new point after the velocity change.
     *
     * @param p is the point before moving.
     * @return new point after the moving by the vector.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * Gets dx and dy speeds and return the Velocity object.
     *
     * @param angle is the angel of the speed.
     * @param speed is the speed.
     * @return a new velocity object/
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.cos(Math.toRadians(angle));
        double dy = speed * Math.sin(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
}