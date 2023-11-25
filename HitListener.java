/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-05-21
 */

/**
 * This is the HitListener interface.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit. The hitter parameter is the Ball that's doing
     * the hitting.
     *
     * @param beingHit is the block that being hit.
     * @param hitter   is the hitter ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
