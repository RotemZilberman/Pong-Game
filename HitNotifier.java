/**
 * @author Rotem Zilberman 213231418
 * @version 2
 * @since 2022-05-21
 */

/**
 * This is the HitNotifier interface.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     *
     * @param hl is the listener.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl is the listener.
     */
    void removeHitListener(HitListener hl);
}
