/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This is the TextSprite class.
 */
public class TextSprite implements Sprite {
    private String text;
    private int x;
    private int y;

    /**
     * return TextSprite object.
     *
     * @param st is the String.
     * @param x  is the x.
     * @param y  is the y.
     */
    public TextSprite(String st, int x, int y) {
        this.text = st;
        this.x = x;
        this.y = y;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(x, y, text, Consts.FONT_SIZE);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * remove the Text of the game.
     * @param game is the game
     */
    public void removefromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
