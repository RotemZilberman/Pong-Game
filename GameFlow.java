/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */

import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * This is the GameFlow class.
 */
public class GameFlow {
    private AnimationRunner ar;
    private GUI gui;
    private Counter score;
    private Counter lives;

    /**
     * return GameFlow object.
     *
     * @param ar  is the AnimationRunner.
     * @param gui is the GUI.
     */
    public GameFlow(AnimationRunner ar, GUI gui) {
        this.ar = ar;
        this.gui = gui;
        this.score = new Counter();
        this.lives = new Counter();
        lives.increase(7);
    }

    /**
     * running the levels.
     *
     * @param levels is the levels list.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.ar, this.score, this.gui, this.lives);
            level.initialize();
            do {
                level.run();
                if (level.getNumOfBall() == 0) {
                    lives.decrease(1);
                }
            } while (level.getNumOfBall() == 0 && lives.getValue() > 0);

            if (level.getNumOfBall() == 0) {
                this.ar.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(), KeyboardSensor.SPACE_KEY,
                        new LoserScreen(this.gui.getKeyboardSensor(), this.score)));
                this.gui.close();
                return;
            }
        }
        this.ar.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(), KeyboardSensor.SPACE_KEY,
                new WinningScreen(this.gui.getKeyboardSensor(), this.score)));
        this.gui.close();
    }
}
