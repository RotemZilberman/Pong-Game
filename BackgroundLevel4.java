/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-04-12
 */

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This is the background class.
 */
public class BackgroundLevel4 implements Sprite {
    /**
     * return the background object.
     */
    public BackgroundLevel4() {
    }

    /**
     * gets the surface and draw the background.
     *
     * @param d is the DrawSurface
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.CYAN);
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(Color.white);
        int dx = 8;
        for (int i = 0; i < 12; i++) {
            d.drawLine(100 + dx * i, 500, 80 + dx * i, 600);
        }
        d.setColor(new Color(120, 120, 120));
        d.fillCircle(100, 500, 23);
        d.setColor(new Color(210, 206, 206));
        d.fillCircle(120, 520, 27);
        d.setColor(new Color(120, 120, 120));
        d.fillCircle(140, 490, 29);
        d.setColor(new Color(185, 182, 182));
        d.fillCircle(160, 520, 22);
        d.setColor(new Color(210, 206, 206));
        d.fillCircle(180, 500, 32);
        for (int i = 0; i < 12; i++) {
            d.drawLine(500 + dx * i, 400, 480 + dx * i, 600);
        }
        d.setColor(new Color(120, 120, 120));
        d.fillCircle(500, 400, 23);
        d.setColor(new Color(210, 206, 206));
        d.fillCircle(520, 420, 27);
        d.setColor(new Color(120, 120, 120));
        d.fillCircle(540, 390, 29);
        d.setColor(new Color(185, 182, 182));
        d.fillCircle(560, 420, 22);
        d.setColor(new Color(210, 206, 206));
        d.fillCircle(580, 400, 32);
    }
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
