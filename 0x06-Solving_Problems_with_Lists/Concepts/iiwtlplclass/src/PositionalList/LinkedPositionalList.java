package PositionalList;

import java.util.Iterator;

public class LinkedPositionalList<E> implements PositionalList<E> {

    public class Node<E> implements Position<E> {

        private E element;

        private Node<E> previous;

        private Node<E> next;

        public Node(E element, Node<E> previous, Node<E> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> header;

    private Node<E> trailer;

    int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Position<E> first() {
        Position<E> first = position(header.getNext());
        return first;
    }

    @Override
    public Position<E> last() {
        Position<E> last = position(trailer.getPrevious());
        return null;
    }

    @Override
    public Position<E> after(Position<E> position) throws IllegalArgumentException {
        Node<E> after = validate(position);
        return position(after.getNext());
    }

    @Override
    public Position<E> before(Position<E> position) throws IllegalArgumentException {
        Node<E> before = validate(position);
        return position(before.getPrevious());
    }

    @Override
    public Position<E> addFirst(E element) {
        Node<E> leftPosition = header;
        Node<E> rightPosition = header.getNext();
        Node<E> first = new Node<E>(element, leftPosition, rightPosition);
        leftPosition.setNext(first);
        rightPosition.setPrevious(first);
        size++;
        return (Position<E>) first;
    }

    @Override
    public Position<E> addLast(E element) {
        Node<E> leftPosition = trailer.getPrevious();
        Node<E> rightPosition = trailer;
        Node<E> last = new Node<E>(element, leftPosition, rightPosition);
        leftPosition.setNext(last);
        rightPosition.setPrevious(last);
        size++;
        return (Position<E>) last;
    }

    @Override
    public Position<E> addBefore(Position<E> position, E element) {
        Node<E> node = validate(position);
        node.setElement(element);
        Node<E> leftPosition = node.getPrevious();
        Node<E> rightPosition = node;
        node.setPrevious(leftPosition);
        node.setNext(rightPosition);
        leftPosition.setNext(node);
        rightPosition.setPrevious(node);
        size++;
        return (Position<E>) node;
    }

    @Override
    public Position<E> addAfter(Position<E> position, E element) {
        Node<E> node = validate(position);
        node.setElement(element);
        Node<E> leftPosition = node;
        Node<E> rightPosition = node.getNext();
        node.setPrevious(leftPosition);
        node.setNext(rightPosition);
        leftPosition.setNext(node);
        rightPosition.setPrevious(node);
        size++;
        return (Position<E>) node;
    }

    @Override
    public E set(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> node = validate(position);
        E answer = node.getElement();
        node.setElement(element);
        return answer;
    }

    @Override
    public E remove(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        Node<E> leftPosition = node.getPrevious();
        Node<E> rightPosition = node.getNext();
        leftPosition.setNext(node);
        rightPosition.setPrevious(node);
        node.setPrevious(leftPosition);
        node.setNext(rightPosition);
        E answer = node.getElement();
        node.setPrevious(null);
        node.setNext(null);
        node.setElement(null);
        size--;
        return answer;
    }

    public Position<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            return null;
        }
        else return node;
    }

    public Node<E> validate(Position<E> position) {
        if(!(position instanceof Node<E>)) {
            throw new IllegalArgumentException("Invalid position.");
        }
        Node<E> node = (Node<E>) position;
        if(node.getNext() == null) {
            throw new IllegalArgumentException("position is no longer in the list.");
        }
        return node;
    }

    public Position<E> addBetween(Position<E> position, E element) {
        return null;
    }

    /** ---------------- nested PositionIterator class ---------------- */
    public class PositionIterator<E> implements Iterator<Position<E>> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Position<E> next() {
            return null;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    } // ------------ end of nested PositionIterator class ------------

    /** ---------------- nested PositionIterable class ---------------- */
    public class PositionIterable<E> implements Iterable<Position<E>> {

        @Override
        public Iterator<E> iterator() {
            return new PositionIterator<E>();
        }
    } // ------------ end of nested PositionIterable class ------------
}
