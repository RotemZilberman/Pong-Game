/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-04-12
 */

import biuoop.DrawSurface;

import java.util.LinkedList;
import java.util.List;

/**
 * This is the Sprite Collection class.
 */
public class SpriteCollection {
    private LinkedList<Sprite> sprites;

    /**
     * return the sprite collection object.
     */
    public SpriteCollection() {
        sprites = new LinkedList<>();
    }

    /**
     * add the given sprite to the collection.
     *
     * @param s is the sprite.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * remove the given sprite to the collection.
     *
     * @param s is the sprite.
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesCopy = new LinkedList<Sprite>(this.sprites);
        for (Sprite sprite : spritesCopy) {
            sprite.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d is the DrawSurface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
}
