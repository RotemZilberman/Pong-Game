/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-04-12
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;

/**
 * This is the Paddle class.
 */
public class Paddle implements Sprite, Collidable {
    private Color color;
    private Rectangle shape;
    private biuoop.KeyboardSensor keyboard;
    private int speed;

    /**
     * Gets center point, width, height, gui and color and return the Paddle object.
     *
     * @param upperLeft is the upperLeft point.
     * @param width     is the width.
     * @param height    is the height.
     * @param color     is the color.
     * @param gui       is the GUI.
     * @param speed     is the speed.
     */
    public Paddle(Point upperLeft, double width, double height, Color color, biuoop.GUI gui, int speed) {
        this.color = color;
        this.shape = new Rectangle(upperLeft, width, height);
        this.keyboard = gui.getKeyboardSensor();
        this.speed = speed;
    }

    /**
     * moving the paddle left.
     */
    public void moveLeft() {
        Point currentPoint = this.getCollisionRectangle().getUpperLeft();
        this.getCollisionRectangle().setUpperLeft(currentPoint.getX() - this.speed, currentPoint.getY());
    }

    /**
     * moving the paddle right.
     */
    public void moveRight() {
        Point currentPoint = this.getCollisionRectangle().getUpperLeft();
        this.getCollisionRectangle().setUpperLeft(currentPoint.getX() + this.speed, currentPoint.getY());
    }

    /**
     * gets the surface and draw the ball.
     *
     * @param d is the DrawSurface
     */
    @Override
    public void drawOn(DrawSurface d) {
        this.getCollisionRectangle().drawOn(d, this.getColor());
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        Point currentPoint = this.getCollisionRectangle().getUpperLeft();
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            if (currentPoint.getX() - this.speed < Consts.FRAME_THICK) {
                this.getCollisionRectangle().setUpperLeft(Consts.FRAME_THICK, currentPoint.getY());
            } else {
                moveLeft();
            }
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            if (currentPoint.getX() + this.shape.getWidth() + this.speed > Consts.WIDTH - Consts.FRAME_THICK) {
                this.getCollisionRectangle().setUpperLeft(Consts.WIDTH - this.shape.getWidth() - Consts.FRAME_THICK,
                        currentPoint.getY());
            } else {
                moveRight();
            }
        }
    }

    /**
     * Return the shape of the object.
     *
     * @return the shape of the object.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.shape;
    }

    /**
     * return the new velocity expected after the hit.
     *
     * @param collisionPoint  is the collision point.
     * @param currentVelocity is the current velocity line.
     * @return the new velocity expected after the hit.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        List<Line> rectangleLines = this.getCollisionRectangle().getRectangleLines();
        if (rectangleLines.get(0).isOnLine(collisionPoint)) {
            if (currentVelocity.getDx() > 0) {
                currentVelocity.changeDx();
            }
        }
        if (rectangleLines.get(1).isOnLine(collisionPoint)) {
            if (currentVelocity.getDx() < 0) {
                currentVelocity.changeDx();
            }
        }
        if (rectangleLines.get(2).isOnLine(collisionPoint)) {
            double xPoint = this.shape.getUpperLeft().getX();
            double lengthPart = this.shape.getWidth() / 5;
            if (currentVelocity.getDy() > 0) {
                if (collisionPoint.getX() < xPoint + lengthPart) {
                    currentVelocity = Velocity.fromAngleAndSpeed(300 - 90, currentVelocity.getSpeed());
                } else if (collisionPoint.getX() < xPoint + 2 * lengthPart) {
                    currentVelocity = Velocity.fromAngleAndSpeed(330 - 90, currentVelocity.getSpeed());
                } else if (collisionPoint.getX() < xPoint + 3 * lengthPart) {
                    currentVelocity.changeDy();
                } else if (collisionPoint.getX() < xPoint + 4 * lengthPart) {
                    currentVelocity = Velocity.fromAngleAndSpeed(30 - 90, currentVelocity.getSpeed());
                } else {
                    currentVelocity = Velocity.fromAngleAndSpeed(60 - 90, currentVelocity.getSpeed());
                }
            }
        }
        return currentVelocity;
    }

    /**
     * Return the color of the object.
     *
     * @return the color of the object.
     */
    @Override
    public Color getColor() {
        return this.color;
    }

    /**
     * get a game and adding the object to the game.
     *
     * @param game is the game.
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

    /**
     * set a new x to the Shape.
     *
     * @param x is the new x.
     */
    public void setShapeX(double x) {
        this.shape.setUpperLeft(x, this.shape.getUpperLeft().getY());
    }

}