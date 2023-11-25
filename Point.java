/**
 * @author Rotem Zilberman 213231418
 * @version 1
 * @since 2022-03-20
 */

/**
 * This is the Point class.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Gets x and y coordinate and return the point object.
     *
     * @param x is the x coordinate.
     * @param y is the y coordinate.
     */
    public Point(double x, double y) {
        setX(x);
        setY(y);
    }
    /**
     * Gets another point and return the distance between them.
     *
     * @param other is another point.
     * @return the distance between two points.
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2));
    }
    /**
     * Gets another point and return true of false if the points are equals.
     *
     * @param other is another point.
     * @return true of false if the points are equals.
     */
    public boolean equals(Point other) {
        return Math.abs(other.x - this.x) < Consts.MISTAKE_RANGE && Math.abs(other.getY() - this.y)
                < Consts.MISTAKE_RANGE;
    }
    /**
     * gets x coordinate and change the x coordinate value.
     *
     * @param x is the x coordinate.
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * gets y coordinate and change the y coordinate value.
     *
     * @param y is the y coordinate.
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * return the x coordinate of the point.
     *
     * @return the x coordinate of the point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * return the y coordinate of the point.
     *
     * @return the y coordinate of the point.
     */
    public double getY() {
        return this.y;
    }
}