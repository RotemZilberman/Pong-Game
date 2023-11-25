/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This is the background class.
 */
public class BackgroundLevel1 implements Sprite {

    /**
     * return the background object.
     */
    public BackgroundLevel1() {
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(Color.black);
        d.fillCircle(400, 170, 120);
        d.setColor(Color.red);
        d.fillCircle(400, 170, 100);
        d.setColor(Color.blue);
        d.fillCircle(400, 170, 80);
        d.setColor(Color.yellow);
        d.fillCircle(400, 170, 60);
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
        game.addSprite(this);
    }
}
