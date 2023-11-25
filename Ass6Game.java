import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */
public class Ass6Game {
    /**
     * the main runs the game.
     *
     * @param args is the function argument.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", Consts.WIDTH, Consts.HEIGHT);
        AnimationRunner ar = new AnimationRunner(gui, 60);
        GameFlow game = new GameFlow(ar, gui);
        List<LevelInformation> levels = new ArrayList<>();
        for (String st : args) {
            if (st.equals("1")) {
                levels.add(new GameLevel1());
            }
            if (st.equals("2")) {
                levels.add(new GameLevel2());
            }
            if (st.equals("3")) {
                levels.add(new GameLevel3());
            }
            if (st.equals("4")) {
                levels.add(new GameLevel4());
            }
        }
        if (levels.size() == 0) {
            levels.add(new GameLevel1());
            levels.add(new GameLevel2());
            levels.add(new GameLevel3());
            levels.add(new GameLevel4());
        }
        game.runLevels(levels);
    }
}
