/**
 * @author Rotem Zilberman 213231418
 * @version 4
 * @since 2022-06-02
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the GameLevel_1 class.
 */
public class GameLevel1 implements LevelInformation {
    private List<Velocity> listVelocity;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;

    /**
     * return GameLevel_1 object.
     */
    public GameLevel1() {
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(0, -4));
        this.listVelocity = list;
        this.paddleSpeed = 5;
        this.paddleWidth = 100;
        this.levelName = "Direct Hit";
        this.background = new BackgroundLevel1();
        List<Block> listB = new ArrayList<>();
        listB.add(new Block(new Point((double) (Consts.WIDTH - 40) / 2, (double) Consts.HEIGHT / 4), 40,
                40, Color.red));
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
