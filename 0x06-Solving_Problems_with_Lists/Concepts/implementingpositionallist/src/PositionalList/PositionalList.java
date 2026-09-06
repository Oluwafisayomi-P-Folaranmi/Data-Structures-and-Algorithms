package PositionalList;

public interface PositionalList<E> {

    /** Tests whether the list is empty. */
    boolean isEmpty();

    /** Tests whether the list is full. */
    boolean isFull();

    /** Returns the number of elements in the list. */
    int size();

    //  Accessor methods
    /** Returns the first Position in the list (or null, if empty). */
    Position<E> first();

    /** Returns the last Position in the list (or null, if empty). */
    Position<E> last();

    /** Returns the Position immediately before Position p (or null, if p is first). */
    Position<E> before(Position<E> position) throws IllegalArgumentException;

    /** Returns the Position immediately after Position p (or null, if p is last). */
    Position<E> after(Position<E> position) throws IllegalArgumentException;

    // Update methods
    /** Inserts element e at the front of the list and returns its new Position. */
    Position<E> addFirst(E element);

    /** Inserts element e at the back of the list and returns its new Position. */
    Position<E> addLast(E element);

    /** Inserts element e immediately before Position p and returns its new Position. */
    Position<E> addBefore(Position<E> position, E element);

    /** Inserts element e immediately after Position p and returns its new Position. */
    Position<E> addAfter(Position<E> position, E element);

    /** Replaces the element stored at Position p and returns the replaced element. */
    E set(Position<E> position, E element) throws IllegalArgumentException;

    /** Removes the element stored at Position p and returns it (invalidating p). */
    E remove(Position<E> position) throws IllegalArgumentException;
}
