package Queue;

public class CircularlyLinkedList<E> {

    // Nested Node class (identical to that of the SinglyLinkedList class)
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    // Instance variables of the CircularlyLinkedList
    private Node<E> tail = null;   // We store tail (but not head)
    private int size = 0;          // Number of nodes in the list

    // Constructs an initially empty list
    public CircularlyLinkedList() {
    }

    // Access methods

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Returns (but does not remove) the first element
    public E first() {
        if (isEmpty())
            return null;
        return tail.getNext().getElement();   // The head is after the tail
    }

    // Returns (but does not remove) the last element
    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    // Update methods

    // Rotates the first element to the back of the list
    public void rotate() {
        if (tail != null)          // If empty, do nothing
            tail = tail.getNext(); // The old head becomes the new tail
    }

    // Adds element e to the front of the list
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);    // Link to itself circularly
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    // Adds element e to the end of the list
    public void addLast(E e) {
        addFirst(e);               // Insert new element at front of list
        tail = tail.getNext();     // Now new element becomes the tail
    }

    // Removes and returns the first element
    public E removeFirst() {
        if (isEmpty())
            return null;           // Nothing to remove

        Node<E> head = tail.getNext();

        if (head == tail)
            tail = null;           // Must be the only node left
        else
            tail.setNext(head.getNext()); // Remove "head" from the list

        size--;
        return head.getElement();
    }
}
