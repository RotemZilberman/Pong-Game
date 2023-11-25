/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-05-21
 */

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * This is the ScoreIndicator class.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * Gets a counter and return ScoreIndicator object based on the counter.
     *
     * @param counter is the counter.
     */
    public ScoreIndicator(Counter counter) {
        this.score = counter;
    }

    /**
     * Gets a number and increase the counter by the number.
     * @param number is the number.
     */
    public void setScore(int number) {
        this.score.increase(number);
    }
    /**
     * get a game and adding the object to the game.
     *
     * @param game is the game.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    @Override
    public void drawOn(DrawSurface d) {
        String scoreText = "Score: " + this.score.getValue();
        d.setColor(Color.black);
        d.drawText(Consts.WIDTH / 2, 15, scoreText, Consts.FONT_SIZE);
    }

    @Override
    public void timePassed() {
    }

    /**
     * return the score.
     * @return the score.
     */
    public Counter getScore() {
        return score;
    }
}
