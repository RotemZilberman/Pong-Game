/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */

import java.util.List;

/**
 * This is the LevelInformation interface.
 */
public interface LevelInformation {
    /**
     * return the number of balls.
     *
     * @return the number of balls.
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     *
     * @return List of Velocity.
     */
    List<Velocity> initialBallVelocities();

    /**
     * return paddle Speed.
     *
     * @return paddle Speed.
     */
    int paddleSpeed();

    /**
     * return paddle Width.
     *
     * @return paddle Width.
     */
    int paddleWidth();

    /**
     * return the levelName.
     *
     * @return levelName.
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return the blocks list.
     */
    List<Block> blocks();

    /**
     * return the number Of Blocks To Remove.
     *
     * @return the number Of Blocks To Remove.
     */
    int numberOfBlocksToRemove();
}