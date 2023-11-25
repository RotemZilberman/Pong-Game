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
 * This is the ball class.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private Color color;
    private Velocity v;
    private GameEnvironment environment;
    private List<HitListener> hitListeners;

    /**
     * Gets center point, radius and color and return the ball object.
     *
     * @param center is the center point.
     * @param r      is the radius.
     * @param color  is the color of the ball.
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * Gets center point, radius and color and return the ball object.
     *
     * @param center is the center point.
     * @param r      is the radius.
     * @param color  is the color of the ball.
     * @param v      is the Velocity.
     */
    public Ball(Point center, int r, Color color, Velocity v) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.setVelocity(v);
    }

    /**
     * Gets x, y of the center point, radius and color and return the ball object.
     *
     * @param x     is the x coordinate of the center point.
     * @param y     is the y coordinate of the center point.
     * @param r     is the radius.
     * @param color is the color of the ball.
     * @param v     is the Velocity.
     */
    public Ball(int x, int y, int r, Color color, Velocity v) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.setVelocity(v);
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * return the x coordinate of the ball.
     *
     * @return the x coordinate of the ball
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * return the y coordinate of the ball.
     *
     * @return the y coordinate of the ball
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * return the area of the ball.
     *
     * @return the area of the ball
     */
    public int getSize() {
        return (int) (3.14 * Math.pow(this.r, 2));
    }

    /**
     * return the game environment of the ball.
     *
     * @return the game environment of the ball
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * return the color of the ball.
     *
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * gets the surface and draw the ball.
     *
     * @param surface is the DrawSurface
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.r);
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.r);
    }

    /**
     * change the velocity value.
     *
     * @param v is the velocity object
     */
    public void setVelocity(Velocity v) {
        this.v = v;
    }

    /**
     * gets dx and dy value and change the velocity value.
     *
     * @param dx is the dx value of the velocity object
     * @param dy is the dy value of the velocity object
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * change the game environment value.
     *
     * @param environment is the game environment object
     */
    public void setEnvironment(GameEnvironment environment) {
        this.environment = environment;
    }

    /**
     * return the velocity of the ball.
     *
     * @return the area of the ball
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * change the center value.
     *
     * @param newCenter is the new center object
     */
    public void setCenter(Point newCenter) {
        this.center = newCenter;
    }

    /**
     * change the position of the ball by changing the center point value.
     */

    public void moveOneStep() {
        Point nextCenter = this.getVelocity().applyToPoint(this.center);
        Line trajectory = new Line(this.center, nextCenter);
        CollisionInfo collisionInfo = environment.getClosestCollision(trajectory);
        if (collisionInfo != null) {
            Point collisionPoint = collisionInfo.collisionPoint();
            double dxSpeed = this.getVelocity().getDx();
            this.setVelocity(collisionInfo.collisionObject().hit(this, collisionPoint, this.getVelocity()));
            if (Math.abs(dxSpeed - this.getVelocity().getDx()) < Consts.MISTAKE_RANGE) {
                collisionPoint.setY(Math.signum(this.getVelocity().getDy()) + collisionPoint.getY());
                this.setCenter(collisionPoint);
            } else {
                collisionPoint.setX(Math.signum(this.getVelocity().getDx()) + collisionPoint.getX());
                this.setCenter(collisionPoint);
            }
            return;
        }
        this.setCenter(nextCenter);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * get a game and adding the object to the game.
     *
     * @param game is the game.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * get a game and removing the object from the game.
     *
     * @param game is the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}