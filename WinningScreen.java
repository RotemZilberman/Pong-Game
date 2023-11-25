/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * This is the WinningScreen class.
 */
public class WinningScreen implements Animation {
    private KeyboardSensor keyboard;
    private Counter score;
    private boolean stop;

    /**
     * return WinningScreen object.
     *
     * @param k     is the KeyboardSensor.
     * @param score is the score counter.
     */
    public WinningScreen(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.red);
        d.drawText(d.getWidth() / 4, d.getHeight() / 3, "You Won", 32);
        d.drawText(d.getWidth() / 4, d.getHeight() / 2, "You Have " + score.getValue() + " Points", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}