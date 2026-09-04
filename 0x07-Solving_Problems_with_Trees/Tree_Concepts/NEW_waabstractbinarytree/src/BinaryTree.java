import java.util.Iterator;
import java.util.List;

public interface BinaryTree<E> {

    /** Fundamental methods common to general trees */
    Position<E> root();

    Position<E> parent(Position<E> position) throws IllegalArgumentException;

    List<Position<E>> children(Position<E> position) throws IllegalArgumentException;

    int numChildren(Position<E> position) throws IllegalArgumentException;

    /** A tree supports the following query methods */
    boolean isExternal(Position<E> position) throws IllegalArgumentException;

    boolean isRoot(Position<E> position) throws IllegalArgumentException;

    boolean isInternal(Position<E> position) throws IllegalArgumentException;

    /** Trees support a number of more general methods,
     * unrelated to the specific structure of the tree */
    boolean isEmpty();

    int size();

    int depth(Position<E> position);

    int height(Position<E> position);

    Iterator<E> iterator();
    Iterable<Position<E>> positions();

    /** Binary tree is a specialization of a tree that supports three additional accessor methods*/
    Position<E> left(Position<E> position) throws IllegalArgumentException;

    Position<E> right(Position<E> position) throws IllegalArgumentException;

    Position<E> sibling(Position<E> position) throws IllegalArgumentException;
}
