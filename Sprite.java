/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-04-12
 */

import biuoop.DrawSurface;

/**
 * This is the Sprite interface.
 */
public interface Sprite {
    /**
     * gets the surface and draw the ball.
     *
     * @param d is the DrawSurface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * add the sprite to the game.
     * @param game is the game.
     */
    void addToGame(GameLevel game);

}