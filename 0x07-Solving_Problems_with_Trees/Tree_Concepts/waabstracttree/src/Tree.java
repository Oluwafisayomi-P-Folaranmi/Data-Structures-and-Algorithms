import java.util.Iterator;
import java.util.List;

public interface Tree<E> extends Iterable<E> {

    Position<E> root();
    Position<E> parent(Position<E> position) throws IllegalArgumentException;
    List<Position<E>> children(Position<E> position) throws IllegalArgumentException;
    int numChildren(Position<E> position) throws IllegalArgumentException;

    boolean isInternal(Position<E> position) throws IllegalArgumentException;
    boolean isExternal(Position<E> position) throws IllegalArgumentException;
    boolean isRoot(Position<E> position) throws IllegalArgumentException;

    boolean isEmpty();
    int size();

    Iterator<E> iterator();
    Iterable<Position<E>> positions();
}
