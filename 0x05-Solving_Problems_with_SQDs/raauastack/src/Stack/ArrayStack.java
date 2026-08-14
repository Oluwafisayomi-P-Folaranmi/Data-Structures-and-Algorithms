package Stack;

public class ArrayStack<E> implements Stack<E>{

    private E[] data;
    private final int CAPACITY = 1000;
    private int head = -1;

    public ArrayStack() {

        this.data = (E[]) new Object[CAPACITY];
    }

    public ArrayStack(int capacity) {

        this.data = (E[]) new Object[capacity];
    }

    // Access methods
    @Override
    public int size() {
        return head + 1;
    }

    @Override
    public boolean isEmpty() {
        return head == -1;
    }

    @Override
    public boolean isFull() {

        return head == data.length - 1;
    }

    // Update methods
    @Override
    public void push(E e) {

        if (isFull())
            throw new IndexOutOfBoundsException("The stack is full.");
        else {
            head++;
            data[head] = e;
        }
    }

    @Override
    public E top() {

        if (isEmpty()) {
            throw new IllegalArgumentException("The stack is empty.");
        } else {
            return data[head];
        }
    }

    @Override
    public E pop() {

        if (isEmpty()) {
            throw new IllegalArgumentException("The stack is empty.");
        } else {
            E oldData = data[head];
            data[head] = null;
            head--;
            return oldData;
        }
    }
}
