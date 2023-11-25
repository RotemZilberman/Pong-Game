/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Random;

/**
 * This is the background class.
 */
public class BackgroundLevel3 implements Sprite {
    private int x = 0;
    private int y = 70;
    private Color color = Color.RED;
    private int lastAction = 1;

    /**
     * return the background object.
     */
    public BackgroundLevel3() {
    }

    @Override
    public void drawOn(DrawSurface d) {
        if (x > d.getWidth()) {
            color = new Color(new Random().nextInt(255), new Random().nextInt(255),
                    new Random().nextInt(255));
            x = 0;
            y = 70;
            lastAction = 1;
        }
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 20, d.getWidth(), d.getHeight());
        int size = 20;
        int size2 = (int) (size * 1.1);
        d.setColor(Color.black);
        d.fillCircle(x, y, size2);
        d.fillRectangle(x - size2, y, 2 * size2, 2 * size2);
        d.fillRectangle(x - size2, y + 2 * size2, size2 - 2, size2 / 2 - size2 / 10);
        d.fillRectangle(x + size2 - (size2 - 2), y + 2 * size2, size2 - 2, size2 / 2 - size2 / 10);
        d.fillCircle(x - size2 + size2 / 2 - 1, y + 2 * size2 + size2 / 2 - size2 / 10 - 3, size2 / 2 - 1);
        d.fillCircle(x + size2 - (size2 - 2) + size2 / 2 - 1, y + 2 * size2 + size2 / 2 - size2 / 10 - 3,
                size2 / 2 - 1);
        d.fillRectangle(x - size2 - size2 / 3 + 1, y + size2 / 4, size2 / 3, 2 * size2 - size2 / 3);
        d.fillCircle(x - size2 - size2 / 3 + size2 / 6 + 1, y + size2 / 4, size2 / 6);
        d.fillCircle(x - size2 - size2 / 3 + size2 / 6 + 1, y + size2 / 10 + 2 * size2 - size2 / 6 - 1, size2 / 6);
        d.setColor(color);
        d.fillCircle(x, y, size);
        d.fillRectangle(x - size, y, 2 * size, 2 * size);
        d.fillRectangle(x - size, y + 2 * size, size - 2, size / 2 - size / 10);
        d.fillRectangle(x + size - (size - 2), y + 2 * size, size - 2, size / 2 - size / 10);
        d.fillCircle(x - size + size / 2 - 1, y + 2 * size + size / 2 - size / 10, size / 2 - 1);
        d.fillCircle(x + size - (size - 2) + size / 2 - 1, y + 2 * size + size / 2 - size / 10, size / 2 - 1);
        d.fillRectangle(x - size - size / 3, y + size / 4, size / 3, 2 * size - size / 3);
        d.fillCircle(x - size - size / 3 + size / 6, y + size / 4, size / 6);
        d.fillCircle(x - size - size / 3 + size / 6, y + size / 10 + 2 * size - size / 6, size / 6);
        d.setColor(Color.black);
        d.fillCircle(x + size2 / 5, y + size2 / 4, size2 / 2);
        d.fillCircle(x + size2 / 2 + size2 / 4, y + size2 / 4, size2 / 2);
        d.fillRectangle(x + size2 / 5, y + size2 / 4 - size2 / 2, size2 / 2 + size2 / 4 - size2 / 5, size2);
        d.setColor(Color.GRAY);
        d.fillCircle(x + size / 5, y + size / 4, size / 2);
        d.fillCircle(x + size / 2 + size / 4, y + size / 4, size / 2);
        d.fillRectangle(x + size / 5, y + size / 4 - size / 2, size / 2 + size / 4 - size / 5, size);
        d.setColor(Color.black);
        d.drawLine(x - size2, y, x - size2, y + 2 * size2);
        for (int i = 0; i <= 15; i++) {
            d.setColor(Color.yellow);
            d.fillCircle(x - size - size / 3 + size / 6 - 2 + new Random().nextInt(3), y + 1 + 2 * size
                    + new Random().nextInt(7), 1);
        }
        for (int i = 0; i <= 20; i++) {
            d.setColor(Color.white);
            d.fillCircle(new Random().nextInt((d.getWidth())), new Random().nextInt((d.getHeight())), 1);
        }
        if (lastAction % 2 == 1 && new Random().nextInt(3) == 2) {
            if (y < 90) {
                y += 1;
            }
        } else {
            if (new Random().nextInt(3) == 2 && y > 70) {
                y -= 1;
            }
        }
        lastAction++;
        x += 2;
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
