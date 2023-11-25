/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-04-12
 */

import java.util.ArrayList;
import java.util.List;

/**
 * This is the Game Environment class.
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * return the Game Environment object.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c is the collidable.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c is the collidable.
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    /**
     * if this object will not collide with any of the collidables in this collection, return null.
     * Else, return the information about the closest collision that is going to occur.
     *
     * @param trajectory is the moving line.
     * @return return the information about the closest collision point.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo information = null;
        double distance = -1;
        for (Collidable collide : collidables) {
            Point collision = trajectory.closestIntersectionToStartOfLine(collide.getCollisionRectangle());
            if (collide.getCollisionRectangle().pointInRectangle(trajectory.getStart())) {
                Rectangle collideRec = collide.getCollisionRectangle();
                if (Math.abs(trajectory.getStart().getX() - collideRec.getUpperLeft().getX())
                        < collideRec.getUpperLeft().getX() + collideRec.getWidth() - trajectory.getStart().getX()) {
                    return new CollisionInfo(new Point(collideRec.getUpperLeft().getX() - 1, Consts.HEIGHT
                            - Consts.FRAME_THICK - collideRec.getHeight() / 2), collide);
                } else {
                    return new CollisionInfo(new Point(collideRec.getUpperLeft().getX() + collideRec.getWidth() + 1,
                            Consts.HEIGHT - Consts.FRAME_THICK - collideRec.getHeight() / 2), collide);
                }
            }
            if ((collision != null) && (information == null || trajectory.getStart().distance(collision) < distance)) {
                distance = trajectory.getStart().distance(collision);
                information = new CollisionInfo(collision, collide);
            }
        }
        return information;
    }
}
