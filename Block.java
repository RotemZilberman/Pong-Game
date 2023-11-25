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
 * This is the block class.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Rectangle shape;
    private Color color;

    /**
     * Gets upperLeft point, width, color and height and return the Block object.
     *
     * @param upperLeft is the upperLeft point.
     * @param width     is the width.
     * @param color     is the color of the ball.
     * @param height    is the height.
     */
    public Block(Point upperLeft, double width, double height, Color color) {
        this.shape = new Rectangle(upperLeft, width, height);
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
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
     * Return the color of the object.
     *
     * @return the color of the object.
     */
    @Override
    public Color getColor() {
        return this.color;
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
            if (currentVelocity.getDy() > 0) {
                currentVelocity.changeDy();
            }
        }
        if (rectangleLines.get(3).isOnLine(collisionPoint)) {
            if (currentVelocity.getDy() < 0) {
                currentVelocity.changeDy();
            }
        }
        this.notifyHit(hitter);
        return currentVelocity;
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
     * get a game and removing the object from the game.
     *
     * @param game is the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    private void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
