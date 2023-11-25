/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * This is the ball class.
 */
public class AnimationRunner {
    private GUI gui;
    private double framesPerSecond;

    /**
     * return AnimationRunner object.
     *
     * @param gui             is Gui
     * @param framesPerSecond is the frames Per Second
     */
    public AnimationRunner(GUI gui, double framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * running the Animation.
     *
     * @param animation is the running animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = (int) (1000 / this.framesPerSecond);
        Sleeper sleeper = new Sleeper();
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
