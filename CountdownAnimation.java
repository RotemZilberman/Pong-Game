/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This is the CountdownAnimation class.
 */
public class CountdownAnimation implements Animation {
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean running;

    /**
     * return CountdownAnimation object.
     *
     * @param countFrom  is the number to count from.
     * @param gameScreen is the game screen.
     */
    public CountdownAnimation(int countFrom, SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.running = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(new Color(235, 236, 240));
        d.fillCircle(d.getWidth() / 2 + 10, d.getHeight() / 2 - 10, 80);
        d.setColor(Color.black);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, "" + (this.countFrom), 50);
        this.countFrom--;
        if (this.countFrom == 0) {
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}