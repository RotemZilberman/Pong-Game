/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-05-21
 */

/**
 * This is the ScoreIndicator class.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Gets a counter and return ScoreIndicator object based on the counter.
     *
     * @param scoreCounter is the counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}