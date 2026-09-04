import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedBinaryTree<E> implements BinaryTree<E> {

    protected static class Node<E> implements Position<E> {
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child (if any)
        private Node<E> right; // a reference to the right child (if any)
        private E element; // an element stored at this node

        /** Constructs a node with the given element and neighbors. */
        public Node(E e,
                    Node<E> above,
                    Node<E> leftChild,
                    Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        // accessor methods
        @Override
        public E getElement() {
            return element;
        }

        public Node<E> getParent() { return parent; }

        public Node<E> getLeft() { return left; }

        public Node<E> getRight() { return right; }

        // update methods
        public void setElement(E e) { element = e; }

        public void setParent(Node<E> parentNode) { parent = parentNode; }

        public void setLeft(Node<E> leftChild) { left = leftChild; }

        public void setRight(Node<E> rightChild) { right = rightChild; }
    }

    /** LinkedBinaryTree instance variables */
    protected Node<E> root = null; // root of the tree
    private int size = 0; // number of nodes in the tree

    /** Constructor */
    public LinkedBinaryTree() { // constructs an empty binary tree

    }

    /** --------------------------------- Fundamental query methods ---------------------------------
     *  ---------------------------------     for general trees     --------------------------------- */
    /** Common to general trees */
    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return node.getParent();
    }

    @Override
    public List<Position<E>> children(Position<E> position) throws IllegalArgumentException {
        List<Position<E>> snapshot = new ArrayList<>(2); // max capacity of 2
        if (left(position) != null)
            snapshot.add(left(position));
        if (right(position) != null)
            snapshot.add(right(position));
        return snapshot;
    }

    @Override
    public int numChildren(Position<E> position) throws IllegalArgumentException {
        int count=0;
        if (left(position) != null)
            count++;
        if (right(position) != null)
            count++;
        return count;
    }

    @Override
    public boolean isExternal(Position<E> position) throws IllegalArgumentException {
        return (numChildren(position) > 0);
    }

    @Override
    public boolean isRoot(Position<E> position) throws IllegalArgumentException {
        return position == root();
    }

    @Override
    public boolean isInternal(Position<E> position) throws IllegalArgumentException {
        return (numChildren(position) == 0);
    }

    @Override
    public int depth(Position<E> position) {
        if (isRoot(position))
            return 0;
        else
            return 1 + depth(parent(position));
    }

    @Override
    public int height(Position<E> position) {
        int h = 0; // b
        for (Position<E> children : children(position)) {
            h = Math.max(h, 1 + height(children));
        }
        return h;
    }

    /** Common query methods */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return 0;
    }

    /** --------------------------------- Iterators ---------------------------------
     *  -------------------------------------------------------------------------- */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    /** --------------------------------- Accessors methods ---------------------------------
     *  ---------------------------------------------------------------------------------- */
    @Override
    public Position<E> left(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return node.getRight();
    }

    @Override
    public Position<E> sibling(Position<E> position) throws IllegalArgumentException {
        Position<E> parent = parent(position);
        if (parent == null) return null; // p must be the root
        if (position == left(parent)) // p is a left child
            return right(parent); // (right child might be null)
        else // p is a right child
            return left(parent); // (left child might be null)
    }

    /** --------------------------------- Update methods ------------------------------------
     *  ---------------------------------------------------------------------------------- */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty())
            throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> position, E e) throws IllegalStateException {
        Node<E> parent = validate(position);
        if (parent.getLeft( ) != null)
            throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> position, E e) throws IllegalStateException {
        Node<E> parent = validate(position);
        if (parent.getRight( ) != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public E set(Position<E> position, E e) throws IllegalArgumentException {
        Node<E> node = validate(position);
        E temp = node.getElement( );
        node.setElement(e);
        return temp;
    }

    /** Attaches trees t1 and t2 as left and right subtrees of external p. */
    public void attach(
                        Position<E> position,
                        LinkedBinaryTree<E> tree1,
                        LinkedBinaryTree<E> tree2
    ) {
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
    public E remove(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        if (numChildren(position) == 2)
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
        size--;
        E temp = node.getElement( );
        node.setElement(null); // help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our convention for defunct node
        return temp;
    }

    /** --------------------------------- Utility methods -----------------------------------
     *  ---------------------------------------------------------------------------------- */
    /** Factory function to create a new node storing element e. */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    /** Validates the position and returns it as a node. */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }
} //----------- end of LinkedBinaryTree class -----------
