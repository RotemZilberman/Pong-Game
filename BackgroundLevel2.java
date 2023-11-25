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
public class BackgroundLevel2 implements Sprite {

    /**
     * return the background object.
     */
    public BackgroundLevel2() {
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        d.setColor(Color.decode("#F0BA70"));
        d.fillCircle(150, 150, 60);
        int number = 200;
        int startX = 25;
        int endX = 600;
        for (int i = 1; i <= number; i++) {
            d.drawLine(150, 150, (endX - startX) / number * i, 250);
        }
        d.setColor(Color.decode("#F68656"));
        d.fillCircle(150, 150, 54);
        d.setColor(Color.decode("#EA5A3E"));
        d.fillCircle(150, 150, 52);
        d.setColor(Color.decode("#DA2B27"));
        d.fillCircle(150, 150, 48);
        d.setColor(Color.decode("#C12600"));
        d.fillCircle(150, 150, 40);
        d.setColor(Color.black);
        d.fillCircle(150, 150, 10);
        d.setColor(Color.decode("#F0BA70"));
        d.fillCircle(650, 150, 60);
        startX = 400;
        endX = 800;
        for (int i = 1; i <= number; i++) {
            d.drawLine(650, 150, (endX - startX) / number * i + 400, 250);
        }
        d.setColor(Color.decode("#F68656"));
        d.fillCircle(650, 150, 54);
        d.setColor(Color.decode("#EA5A3E"));
        d.fillCircle(650, 150, 52);
        d.setColor(Color.decode("#DA2B27"));
        d.fillCircle(650, 150, 48);
        d.setColor(Color.decode("#C12600"));
        d.fillCircle(650, 150, 40);
        d.setColor(Color.black);
        d.fillCircle(650, 150, 10);
        d.setColor(Color.orange);
        d.fillRectangle(d.getWidth() / 2 - 10, 350, 20, 60);
        d.fillCircle(d.getWidth() / 2, 410, 10);
        d.fillCircle(d.getWidth() / 2, 350, 10);

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
