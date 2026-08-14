package Deque;

/**
 * Interface for a double-ended queue: a collection of elements that can be
 * inserted and removed at both ends.
 */
public interface Deque<E> {

    /**
     * Returns the number of elements in the deque.
     *
     * @return number of elements in the deque
     */
    int size();

    /**
     * Tests whether the deque is empty.
     *
     * @return {@code true} if the deque is empty, {@code false} otherwise
     */
    boolean isEmpty();

    /**
     * Returns, but does not remove, the first element of the deque.
     *
     * @return the first element, or {@code null} if the deque is empty
     */
    E first();

    /**
     * Returns, but does not remove, the last element of the deque.
     *
     * @return the last element, or {@code null} if the deque is empty
     */
    E last();

    /**
     * Inserts an element at the front of the deque.
     *
     * @param e the element to insert
     */
    void addFirst(E e);

    /**
     * Inserts an element at the back of the deque.
     *
     * @param e the element to insert
     */
    void addLast(E e);

    /**
     * Removes and returns the first element of the deque.
     *
     * @return the removed element, or {@code null} if the deque is empty
     */
    E removeFirst();

    /**
     * Removes and returns the last element of the deque.
     *
     * @return the removed element, or {@code null} if the deque is empty
     */
    E removeLast();
}
