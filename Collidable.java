/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-05-21
 */


import java.awt.Color;
/**
 * This is the Collidable interface.
 */
public interface Collidable {
    /**
     * Return the shape of the object.
     *
     * @return the shape of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * return the new velocity expected after the hit.
     *
     * @param collisionPoint  is the collision point.
     * @param currentVelocity is the current velocity line.
     * @param hitter is the hitter ball.
     * @return the new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     * Return the color of the object.
     *
     * @return the color of the object.
     */
    Color getColor();

}