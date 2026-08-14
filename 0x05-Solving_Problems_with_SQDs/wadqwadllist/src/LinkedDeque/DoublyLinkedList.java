package LinkedDeque;

public class DoublyLinkedList<E> {

    // ---------------- Nested Node class ----------------
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    // -------------- End of Node class ----------------


    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;

        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;

        return trailer.getPrev().getElement();
    }

    // Add at the beginning
    public void addFirst(E e) {
        Node<E> firstNode = header.getNext();

        Node<E> newNode = new Node<>(e, header, firstNode);

        header.setNext(newNode);
        firstNode.setPrev(newNode);

        size++;
    }

    // Add at the end
    public void addLast(E e) {
        Node<E> lastNode = trailer.getPrev();

        Node<E> newNode = new Node<>(e, lastNode, trailer);

        lastNode.setNext(newNode);
        trailer.setPrev(newNode);

        size++;
    }

    // Remove first node
    public E removeFirst() {
        if (isEmpty())
            return null;

        Node<E> firstNode = header.getNext();
        Node<E> secondNode = firstNode.getNext();

        header.setNext(secondNode);
        secondNode.setPrev(header);

        size--;

        return firstNode.getElement();
    }

    // Remove last node
    public E removeLast() {
        if (isEmpty())
            return null;

        Node<E> lastNode = trailer.getPrev();
        Node<E> secondLast = lastNode.getPrev();

        secondLast.setNext(trailer);
        trailer.setPrev(secondLast);

        size--;

        return lastNode.getElement();
    }
}
