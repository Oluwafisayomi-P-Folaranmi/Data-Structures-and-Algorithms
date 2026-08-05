package Stack;

public class ArrayStack<E> implements Stack<E>{

    private E[] data;
    private final int CAPACITY = 1000;
    private int t = -1;

    public ArrayStack() {

        this.data = (E[]) new Object[CAPACITY];
    }

    public ArrayStack(int capacity) {

        this.data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E top() {
        return null;
    }

    @Override
    public E pop() {
        return null;
    }
}
