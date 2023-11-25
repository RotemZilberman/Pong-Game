/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-04-12
 */

/**
 * This is the CollisionInfo class.
 */
public class CollisionInfo {
    private Point collision;
    private Collidable collides;

    /**
     * Gets collision point and collides and return the CollisionInfo object.
     *
     * @param collision is the collision point.
     * @param collides  is the collides.
     */
    public CollisionInfo(Point collision, Collidable collides) {
        this.collides = collides;
        this.collision = collision;
    }

    /**
     * return the collision point of the ball.
     *
     * @return the collision point of the ball.
     */
    public Point collisionPoint() {
        return this.collision;
    }

    /**
     * return the collision object of the ball.
     *
     * @return the collision object of the ball.
     */
    public Collidable collisionObject() {
        return this.collides;
    }
}