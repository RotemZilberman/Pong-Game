/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-04-12
 */

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the Rectangle class.
 */
public class Rectangle {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Gets upperLeft point, width and height and return the Rectangle object.
     *
     * @param upperLeft is the upperLeft point.
     * @param width     is the width.
     * @param height    is the height.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * return List of all the lines that the rectangle made of.
     *
     * @return List of all the lines that the rectangle made of.
     */
    public List<Line> getRectangleLines() {
        List<Line> rectangleLines = new ArrayList<>();
        rectangleLines.add(new Line(this.getUpperLeft().getX(), this.getUpperLeft().getY(),
                this.getUpperLeft().getX(), this.getUpperLeft().getY() + this.getHeight()));
        rectangleLines.add(new Line(this.getUpperLeft().getX() + this.getWidth(), this.getUpperLeft().getY(),
                this.getUpperLeft().getX() + this.getWidth(), this.getUpperLeft().getY() + this.getHeight()));
        rectangleLines.add(new Line(this.getUpperLeft().getX(), this.getUpperLeft().getY(),
                this.getUpperLeft().getX() + this.getWidth(), this.getUpperLeft().getY()));
        rectangleLines.add(new Line(this.getUpperLeft().getX(), this.getUpperLeft().getY() + this.getHeight(),
                this.getUpperLeft().getX() + this.getWidth(), this.getUpperLeft().getY() + this.getHeight()));
        return rectangleLines;
    }

    /**
     * gets line return List of all the intersection points with him.
     *
     * @param line is the checked line.
     * @return List of all the lines that the rectangle made of.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<>();
        List<Line> rectangleLines = this.getRectangleLines();
        Point intersXL = line.intersectionWith(rectangleLines.get(0));
        Point intersXR = line.intersectionWith(rectangleLines.get(1));
        Point intersYU = line.intersectionWith(rectangleLines.get(2));
        Point intersYD = line.intersectionWith(rectangleLines.get(3));
        if (intersXL != null) {
            intersectionPoints.add(intersXL);
        }
        if (intersXR != null) {
            intersectionPoints.add(intersXR);
        }
        if (intersYU != null) {
            intersectionPoints.add(intersYU);
        }
        if (intersYD != null) {
            intersectionPoints.add(intersYD);
        }
        return intersectionPoints;
    }

    /**
     * return the width.
     *
     * @return the width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * return the width.
     *
     * @return the width.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * return the upperLeft point.
     *
     * @return the upperLeft point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * gets x,y coordinate and change the UpperLeft point value.
     *
     * @param x is the x coordinate.
     * @param y is the y coordinate.
     */
    public void setUpperLeft(double x, double y) {
        this.upperLeft = new Point(x, y);
    }

    /**
     * gets the surface and color and draw the ball by the color.
     *
     * @param color is the color.
     * @param d     is the DrawSurface
     */
    public void drawOn(DrawSurface d, Color color) {
        Point upperLeft = this.getUpperLeft();
        d.setColor(color);
        d.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) this.getWidth(),
                (int) this.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) this.getWidth(),
                (int) this.getHeight());
    }

    /**
     * gets point and return true or false if the point is in the rectangle.
     *
     * @param point is the point.
     * @return return true or false if the point is in the rectangle.
     */
    public boolean pointInRectangle(Point point) {
        return point.getX() > this.getUpperLeft().getX() && point.getX() < this.getUpperLeft().getX() + this.getWidth()
                && point.getY() > this.getUpperLeft().getY() && point.getY() < this.getUpperLeft().getY()
                + this.getHeight();
    }
}