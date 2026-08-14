package Queue;

/**
 * A queue in which the front element can be rotated to the rear.
 *
 * @author Oluwafisayomi P. Folaranmi
 */
public interface CircularQueue<E> extends Queue<E> {

    /**
     * Rotates the front element of the queue to the back of the queue.
     * This does nothing if the queue is empty.
     */
    void rotate();
}
