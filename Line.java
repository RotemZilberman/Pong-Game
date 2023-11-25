/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-04-12
 */

import java.util.List;

/**
 * This is the line class.
 */
public class Line {

    private Point start;
    private Point end;

    /**
     * Gets start point and end point and return the line object.
     *
     * @param start is the start point.
     * @param end   is the end point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Gets x,y if the start point and x,y of the end point and return the line object.
     *
     * @param x1 is the x of the start point.
     * @param y1 is the y of the start point.
     * @param x2 is the x of the end point.
     * @param y2 is the y of the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        setStart(new Point(x1, y1));
        setEnd(new Point(x2, y2));
    }

    /**
     * return the start point of the line.
     *
     * @return the start point of the line.
     */
    public Point getStart() {
        return this.start;
    }

    /**
     * return the end point of the line.
     *
     * @return the end point of the line.
     */
    public Point getEnd() {
        return this.end;
    }

    /**
     * gets start point and change the start point value.
     *
     * @param start is the start point.
     */
    public void setStart(Point start) {
        this.start = start;
    }

    /**
     * gets end point and change the end point value.
     *
     * @param end is the start point.
     */
    public void setEnd(Point end) {
        this.end = end;
    }

    /**
     * return the length of the line.
     *
     * @return the length of the line.
     */
    public double length() {
        return this.start.distance(end);
    }

    /**
     * return the middle point of the line.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        return new Point((getStart().getX() + getEnd().getX()) / 2, (getStart().getY() + getEnd().getY()) / 2);
    }

    /**
     * return the incline of the line.
     *
     * @return the incline of the line.
     */
    public double incline() {
        if (Math.abs(this.getStart().getX() - this.getEnd().getX()) < Consts.MISTAKE_RANGE) {
            return Integer.MAX_VALUE;
        }
        return (this.getStart().getY() - this.getEnd().getY()) / (this.getStart().getX() - this.getEnd().getX());
    }

    /**
     * return true if the absolut incline of the lines are equal and false weatherize.
     *
     * @param other is another line.
     * @return true or false if the incline between the tow-line are equals.
     */
    public Boolean sameIncline(Line other) {
        return Math.abs(Math.abs(this.incline()) - Math.abs(other.incline())) < Consts.MISTAKE_RANGE;
    }

    /**
     * return the B part of the line equation.
     *
     * @return the B part of the line equation.
     */
    public double addB() {
        return this.getStart().getY() - this.incline() * this.getStart().getX();
    }

    /**
     * return true or false if point is on the line.
     *
     * @param other is the point being tasted
     * @return true or false if point is on the line.
     */
    public boolean isOnLine(Point other) {
        if (this.incline() == Integer.MAX_VALUE) {
            if (other.getX() == this.getStart().getX()) {
                if (other.getY() - Consts.MISTAKE_RANGE > Math.max(this.getEnd().getY(), this.start.getY())) {
                    return false;
                }
                return !(other.getY() + Consts.MISTAKE_RANGE < Math.min(this.getEnd().getY(), this.start.getY()));
            }
            return false;
        }
        if (Math.abs(this.incline() * other.getX() + this.addB() - other.getY()) < Consts.MISTAKE_RANGE) {
            if (other.getX() - Consts.MISTAKE_RANGE > Math.max(this.getEnd().getX(), this.getStart().getX())) {
                return false;
            }
            return !(other.getX() + Consts.MISTAKE_RANGE < Math.min(this.getEnd().getX(), this.getStart().getX()));
        }
        return false;
    }

    /**
     * return true or false if intersecting point between two lines is existed.
     *
     * @param other is the line being tasted
     * @return true or false if intersecting point between two lines is existed.
     */
    public boolean isIntersecting(Line other) {
        if (sameIncline(other)) {
            return other.isOnLine(this.getStart()) || other.isOnLine(this.getEnd()) || this.isOnLine(other.getEnd())
                    || this.isOnLine(other.getStart());
        }
        return this.intersectionWith(other) != null;
    }

    /**
     * Gets a line and returns a point of intersection if there is one such and another returns null.
     *
     * @param other is the line being tasted
     * @return point of intersection if there is one such and another returns null.
     */
    public Point intersectionWith(Line other) {
        if (sameIncline(other)) {
            if (this.getEnd().equals(other.getStart()) || this.getStart().equals(other.getEnd())
                    || this.getEnd().equals(other.getEnd()) || this.getStart().equals(other.getStart())) {
                if (this.equals(other)) {
                    return null;
                } else {
                    if (this.getEnd().equals(other.getStart()) || this.getEnd().equals(other.getEnd())) {
                        return this.getEnd();
                    }
                    return this.getStart();
                }
            }
            return null;
        }
        double intersX, intersY;
        if (this.incline() == Integer.MAX_VALUE || other.incline() == Integer.MAX_VALUE) {
            if (this.incline() == Integer.MAX_VALUE) {
                intersX = this.getEnd().getX();
                intersY = other.incline() * intersX + other.addB();
            } else {
                intersX = other.getEnd().getX();
                intersY = this.incline() * intersX + this.addB();
            }
            Point intersP = new Point(intersX, intersY);
            return this.isOnLine(intersP) && other.isOnLine(intersP) ? intersP : null;
        } else {
            intersX = (this.addB() - other.addB()) / (other.incline() - this.incline());
        }
        intersY = this.incline() * intersX + this.addB();
        Point intersP = new Point(intersX, intersY);
        return this.isOnLine(intersP) && other.isOnLine(intersP) ? intersP : null;
    }

    /**
     * Gets a line and returns true or false if the lines are equals.
     *
     * @param other is the line being tasted.
     * @return true or false if the lines are equals.
     */
    public boolean equals(Line other) {
        if (other.getEnd().equals(this.getEnd())) {
            return other.getStart().equals(this.getStart());
        }
        if (other.getEnd().equals(this.getStart())) {
            return other.getStart().equals(this.getEnd());
        }
        return false;
    }

    /**
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     * @param rect is the rectangle;
     * @return the closest intersection point or null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        if (intersectionPoints.isEmpty()) {
            return null;
        }
        Point closest = null;
        for (Point currentPoint : intersectionPoints) {
            if (closest == null || currentPoint.distance(this.getStart()) < closest.distance(this.getStart())) {
                closest = currentPoint;
            }
        }
        return closest;
    }
}
