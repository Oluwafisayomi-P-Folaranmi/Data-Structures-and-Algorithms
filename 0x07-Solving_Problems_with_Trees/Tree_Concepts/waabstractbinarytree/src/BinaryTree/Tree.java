package BinaryTree;

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


    // nonpublic utility


        // accessor methods (not already implemented in AbstractBinaryTree)
        /** Returns the number of nodes in the tree. */
        public int size() {
            return size;
        }

        /** Returns the root Position of the tree (or null if tree is empty). */
        public Position<E> root() {
            return root;
        }

        /** Returns the Position of p's parent (or null if p is root). */
        public Position<E> parent(Position<E> p) throws IllegalArgumentException {
            Node<E> node = validate(p);
            return node.getParent( );
        }

        /** Returns the Position of p's left child (or null if no child exists). */
        public Position<E> left(Position<E> p) throws IllegalArgumentException {
            Node<E> node = validate(p);
            return node.getLeft( );
        }

        /** Returns the Position of p's right child (or null if no child exists). */
        public Position<E> right(Position<E> p) throws IllegalArgumentException {
            Node<E> node = validate(p);
            return node.getRight( );
        }
}
