/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-05-21
 */

/**
 * This is the counter class.
 */
public class Counter {
    private int number;

    /**
     * set the current number to 0.
     */
    public Counter() {
        this.number = 0;
    }

    /**
     * Gets a number and increase the current number by this number.
     *
     * @param number is how much to add to the current number.
     */
    public void increase(int number) {
        this.number += number;
    }

    /**
     * Gets a number and decrease the current number by this number.
     *
     * @param number is how much to decrease from the current number.
     */
    public void decrease(int number) {
        this.number -= number;
    }

    /**
     * return the current value.
     *
     * @return the current value.
     */
    public int getValue() {
        return this.number;
    }
}
