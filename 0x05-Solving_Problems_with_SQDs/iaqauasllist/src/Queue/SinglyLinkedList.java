package Queue;

public class SinglyLinkedList<E> {

    // Nested Node class
    private class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> node) {
            this.next = node;
        }
    }

    // Instance variables
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    // Constructs an initially empty list
    public SinglyLinkedList() {
    }

    // Returns the number of elements in the list
    public int size() {
        return size;
    }

    // Tests whether the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // ---------------------- Access methods ----------------------
    // Returns (but does not remove) the first element
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    // Returns (but does not remove) the last element
    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // ---------------------- Update methods ----------------------
    // Adds an element to the front of the list
    public void addFirst(E element) {
        Node<E> newNode;

        if (size == 0) {
            newNode = new Node<>(element, null);
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode = new Node<>(element, head);
            head = newNode;
            size++;
        }
    }

    // Adds an element to the end of the list
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, null);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
    }

    // Removes and returns the first element
    public E removeFirst() {
        if (!isEmpty()) {
            Node<E> old = head;
            head = head.getNext();
            size--;

            if (isEmpty()) {
                tail = null;
            }

            return old.getElement();
        }

        return null;
    }
}
