package BinaryTree;

import javax.swing.text.Position;

public abstract class AbstractTree<E> implements Tree<E> {

    // --------------------------- Some general methods ---------------------------
    // + isInternal()
    // + isExternal()
    // + isRoot()
    // + isEmpty()
    // + depth()
    // + height()

    @Override
    public boolean isInternal(Position<E> position) throws IllegalArgumentException {
        return (numChildren(position) > 0);
    }

    @Override
    public boolean isExternal(Position<E> position) throws IllegalArgumentException {
        return (numChildren(position) == 0);
    }

    @Override
    public boolean isRoot(Position<E> position) throws IllegalArgumentException {
        return position == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> position) {
        if (isRoot(position))
            return 0;
        else
            return 1 + depth(parent(position));
    }

    public int height(Position<E> position) {
        int h = 0; // base case if p is external
        for (Position<E> c : children(position))
            h = Math.max(h, 1 + height(c));
        return h;
    }

    /** Attaches trees t1 and t2 as left and right subtrees of external p. */
    public void attach(
                        Position<E> position,
                        LinkedBinaryTree<E> tree1,
                        LinkedBinaryTree<E> tree2) throws IllegalArgumentException {
        Node<E> node = validate(position);
        if (isInternal(position)) throw new IllegalArgumentException("p must be a leaf");
            size += tree1.size( ) + tree2.size( );
        if (!tree1.isEmpty( )) { // attach t1 as left subtree of node
            tree1.root.setParent(node);
            node.setLeft(tree1.root);
            tree1.root = null;
            tree1.size = 0;
        }
        if (!tree2.isEmpty( )) { // attach t2 as right subtree of node
            tree2.root.setParent(node);
            node.setRight(tree2.root);
            tree2.root = null;
            tree2.size = 0;
        }
    }

    /** Removes the node at Position p and replaces it with its child, if any. */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");
        Node<E> child = (node.getLeft( ) != null ? node.getLeft( ) : node.getRight( ) );
        if (child != null)
            child.setParent(node.getParent( )); // child’s grandparent becomes its parent
        if (node == root)
            root = child; // child becomes root
        else {
            Node<E> parent = node.getParent( );
            if (node == parent.getLeft( ))
                parent.setLeft(child);
            else
                parent.setRight(child);
            }
        size−−;
        E temp = node.getElement( );
        node.setElement(null); // help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our convention for defunct node
        return temp;
    }
} //----------- end of LinkedBinaryTree class -----------
