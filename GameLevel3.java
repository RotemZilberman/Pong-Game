/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is the GameLevel_3 object.
 */
public class GameLevel3 implements LevelInformation {
    private List<Velocity> listVelocity;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;

    /**
     * return GameLevel3 object.
     */
    public GameLevel3() {
        int speed = 6;
        List<Velocity> list = new ArrayList<>();
        list.add(Velocity.fromAngleAndSpeed(-20 - 40, speed));
        list.add(Velocity.fromAngleAndSpeed(330 - 90, speed));
        this.listVelocity = list;
        this.paddleSpeed = 7;
        this.paddleWidth = 100;
        this.levelName = "Space 3";
        this.background = new BackgroundLevel3();
        List<Block> listB = new ArrayList<>();
        int widthCube = (Consts.WIDTH - 2 * Consts.FRAME_THICK) / 15;
        int heightCube = (Consts.WIDTH - 2 * Consts.FRAME_THICK) / 35;
        int y = (int) (Consts.HEIGHT / 2.5);
        int x = Consts.WIDTH - Consts.FRAME_THICK - widthCube;
        Random ramdom = new Random();
        int countCube = 6;
        for (int i = 0; i < 6; i++) {
            Color color = new Color(ramdom.nextInt(255) + 1, ramdom.nextInt(255) + 1,
                    ramdom.nextInt(255) + 1);
            for (int j = 0; j < countCube; j++) {
                Block b = new Block(new Point(x, y), widthCube, heightCube, color);
                x -= widthCube;
                listB.add(b);
            }
            y -= heightCube;
            x = Consts.WIDTH - Consts.FRAME_THICK - widthCube;
            countCube++;
        }
        this.blocks = listB;
    }

    @Override
    public int numberOfBalls() {
        return this.listVelocity.size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.listVelocity;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public Sprite getBackground() {
        return this.background;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }
}