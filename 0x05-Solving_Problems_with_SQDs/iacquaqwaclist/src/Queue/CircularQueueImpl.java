package Queue;

public class CircularQueueImpl<E> implements CircularQueue<E> {

    CircularlyLinkedList<E> list = new CircularlyLinkedList<E>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // -------------------- Access methods --------------------
    @Override
    public E first() {
        return list.first();
    }

    // -------------------- Update methods --------------------
    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public void rotate() {
        list.rotate();
    }
}
