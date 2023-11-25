/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-05-21
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * This is the Game class.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private ScoreIndicator score;
    private AnimationRunner runner;
    private boolean running;
    private final LevelInformation level;
    private Counter lives;
    private Paddle paddle;

    /**
     * return GameLevel object.
     * @param level is the LevelInformation.
     * @param animationRunner is the AnimationRunner.
     * @param score is the score counter.
     * @param gui is the GUI.
     * @param lives is the number of lives.
     */
    public GameLevel(LevelInformation level, AnimationRunner animationRunner, Counter score, GUI gui, Counter lives) {
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        this.runner = animationRunner;
        this.score = new ScoreIndicator(score);
        this.level = level;
        this.gui = gui;
        this.remainingBalls = new Counter();
        this.lives = lives;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c is the collidable.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * add the given Sprite to the environment.
     *
     * @param s is the Sprite.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * return the game environment of the game.
     *
     * @return the game environment of the game.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * return the game environment of the game.
     *
     * @return the game environment of the game.
     */
    public SpriteCollection getCollection() {
        return sprites;
    }
    /**
     * return the balls and adding them to the game.
     */
    public void createBallsOnTopOfPaddle() {
        for (Velocity v : level.initialBallVelocities()) {
            Ball ball = new Ball(Consts.WIDTH / 2, Consts.HEIGHT - 2 * Consts.FRAME_THICK, 5, Color.white,
                    new Velocity(v.getDx(), v.getDy()));
            ball.addToGame(this);
            ball.setEnvironment(this.getEnvironment());
        }
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        int width = Consts.WIDTH;
        int height = Consts.HEIGHT;
        int thick = Consts.FRAME_THICK;
        TextSprite lives = new TextSprite("Level Name: " + this.level.levelName(), 600, 15);
        lives.addToGame(this);
        Block xL = new Block(new Point(0, thick + 18), thick, height - 2 * thick + 10, Color.gray);
        Block xR = new Block(new Point(width - thick, thick + 18), thick, height - 2 * thick + 10,
                Color.gray);
        Block yU = new Block(new Point(0, 18), width, thick, Color.gray);
        Block yD = new Block(new Point(0, height - thick), width, thick, Color.BLUE);
        paddle = new Paddle(new Point((double) (width - level.paddleWidth()) / 2,
                Consts.HEIGHT - Consts.FRAME_THICK - Consts.PADDLE_HEIGHT),
                level.paddleWidth(), Consts.PADDLE_HEIGHT, Color.orange, this.gui, level.paddleSpeed());
        this.remainingBlocks = new Counter();
        this.remainingBlocks.increase(level.numberOfBlocksToRemove());
        ScoreTrackingListener scoreTracker = new ScoreTrackingListener(score.getScore());
        BlockRemover remover = new BlockRemover(this, this.remainingBlocks);
        yD.addHitListener(new BallRemover(this, this.remainingBalls));
        yD.addToGame(this);
        level.getBackground().addToGame(this);
        xL.addToGame(this);
        xR.addToGame(this);
        yU.addToGame(this);
        paddle.addToGame(this);
        for (int i = 0; i < level.numberOfBlocksToRemove(); i++) {
            Block b = level.blocks().get(i);
            b.addToGame(this);
            b.addHitListener(remover);
            b.addHitListener(scoreTracker);
        }
        this.score.addToGame(this);
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        paddle.setShapeX((double) (Consts.WIDTH - level.paddleWidth()) / 2);
        TextSprite lives = new TextSprite("Lives: " + this.lives.getValue(), 50, 15);
        lives.addToGame(this);
        this.createBallsOnTopOfPaddle();
        this.remainingBalls.increase(level.numberOfBalls());
        CountdownAnimation counterAnimation = new CountdownAnimation(3, this.sprites);
        new AnimationRunner(this.gui, 1.5).run(counterAnimation);
        this.running = true;
        this.runner.run(this);
        lives.removefromGame(this);
    }

    /**
     * Gets a collidable and remove it from the game environment.
     *
     * @param c is the collidable
     */
    public void removeCollidable(Collidable c) {
        this.getEnvironment().removeCollidable(c);
    }

    /**
     * Gets a sprite and remove it from the sprite collection.
     *
     * @param c is the sprite
     */
    public void removeSprite(Sprite c) {
        this.getCollection().removeSprite(c);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        KeyboardSensor keyboard = this.gui.getKeyboardSensor();
        if (keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard, "space", new PauseScreen(keyboard)));
        }
        if (this.remainingBlocks.getValue() == 0) {
            this.score.setScore(100);
            this.running = false;
        }
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * return number of balls.
     * @return number of balls.
     */
    public int getNumOfBall() {
        return this.remainingBalls.getValue();
    }
}