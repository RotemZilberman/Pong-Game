/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-05-21
 */

/**
 * This is the BlockRemover class.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Gets center point, radius and color and return the ball object.
     *
     * @param game          is the game object.
     * @param removedBlocks is the Blocks counter.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}
