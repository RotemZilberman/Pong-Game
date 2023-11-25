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
 * This is the GameLevel_2 class.
 */
public class GameLevel2 implements LevelInformation {
    private List<Velocity> listVelocity;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;

    /**
     * return GameLevel2 object.
     */
    public GameLevel2() {
        int speed = 6;
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(Velocity.fromAngleAndSpeed(-20 - 20 * i, speed));
            list.add(Velocity.fromAngleAndSpeed(-180 + 30 + 20 * i, speed));
        }
        this.listVelocity = list;
        this.paddleSpeed = 5;
        this.paddleWidth = 650;
        this.levelName = "WildEasy";
        this.background = new BackgroundLevel2();
        List<Block> listB = new ArrayList<>();
        int widthCube = (Consts.WIDTH - 2 * Consts.FRAME_THICK) / 15;
        int heightCube = (Consts.WIDTH - 2 * Consts.FRAME_THICK) / 45;
        int y = (int) (Consts.HEIGHT / 2.5);
        int x = Consts.WIDTH - Consts.FRAME_THICK - widthCube;
        Random ramdom = new Random();
        for (int i = 0; i < 7; i++) {
            Color color = new Color(ramdom.nextInt(255) + 1, ramdom.nextInt(255) + 1,
                    ramdom.nextInt(255) + 1);
            Block b = new Block(new Point(x, y), widthCube, heightCube, color);
            x -= widthCube;
            Block b2 = new Block(new Point(x, y), widthCube, heightCube, color);
            x -= widthCube;
            listB.add(b);
            listB.add(b2);
            if (i == 3) {
                Block b3 = new Block(new Point(x, y), widthCube, heightCube, color);
                x -= widthCube;
                listB.add(b3);
            }
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