/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */
import biuoop.DrawSurface;
/**
 * This is the Animation interface.
 */
public interface Animation {
    /**
     * doing one step in the animation.
     * @param d is the DrawSurface
     */
    void doOneFrame(DrawSurface d);
    /**
     * return true or false if the animation should stop.
     * @return true or false if the animation should stop.
     */
    boolean shouldStop();
}