package ArrayDeque;

public class ArrayDeque<E> implements Deque<E> {

    /** Member variables */
    private E[] data;
    private int size = 0;
    private int capacity;
    private int front;
    private int back;

    /** Constructor */
    public ArrayDeque(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        this.data = temp;
        this.capacity = capacity;
        System.out.println("capacity is: " + capacity);
    }

    /** Getters and Setters */
    private int getSize() {
        return size;
    }

    private E[] getData() {
        return data;
    }

    private int getCapacity() {
        return capacity;
    }

    /** Query methods */
    @Override
    public int size() {
        return getSize();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public E first() {
        return data[front];
    }

    @Override
    public E last() {
        return data[back];
    }

    /** Update methods */
    @Override
    public void addFirst(E e) {
        front = (front - 1 + capacity) % capacity;
        data[front] = e;
    }

    @Override
    public void addLast(E e) {
        back = (front + size) % capacity;
        data[back] = e;
    }

    @Override
    public E removeFirst() {
        E temp = data[front];
        front = (front + 1) % capacity;
        return temp;
    }

    @Override
    public E removeLast() {
        E temp = data[back];
        back = (back - 1 + capacity) % capacity;
        return null;
    }
}
