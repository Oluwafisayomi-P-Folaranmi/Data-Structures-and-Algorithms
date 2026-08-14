package Queue;

public class LinkedQueue<E> implements Queue<E> {

    SinglyLinkedList list = new SinglyLinkedList<>();

    // ------------------ Utility methods ------------------
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // ------------------ Access methods ------------------
    @Override
    public E first() {
        return null;
    }

    // ------------------ Utility methods ------------------
    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return (E) list.removeFirst();
    }
}
