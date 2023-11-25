/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-05-21
 */

/**
 * This is the BallRemover class.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Gets center point, radius and color and return the ball object.
     *
     * @param game           is the game object.
     * @param remainingBalls is the balls counter.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
