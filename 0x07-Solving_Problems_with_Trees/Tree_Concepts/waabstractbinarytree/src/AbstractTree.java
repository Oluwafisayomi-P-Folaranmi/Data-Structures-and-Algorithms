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
}
