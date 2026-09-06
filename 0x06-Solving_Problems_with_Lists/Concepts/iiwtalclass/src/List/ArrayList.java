package List;

public class ArrayList<E> implements List<E> {

    private E[] data;
    private final int CAPACITY = 8;
    private int size = 0;

    // Constructor

    public ArrayList(int capacity) {

        this.data = (E[]) new Object[capacity];
    }

    // Access methods

    /**
     * size: Gets the size of the array list
     * @return integer
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * isEmpty: tells if the array list is empty
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * isFull: tells if the array list is full
     * @return boolean
     */
    public boolean isFull() {
        return size == data.length;
    }

    // Update methods
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Illegal index.");
        }
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Illegal index.");
        }
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Illegal index.");
        }
        if (size == data.length) {
            throw new IllegalStateException("Array is full.");
        }
        int loopStart = size + 1;
        int loopEnd = i;
        for (int start = loopStart; start > loopEnd; start--) {
            data[start] = data[start - 1];
        }
        data[i] = e;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Illegal index.");
        }
        if (i == size - 1) {
            E temp = data[i];
            data[i] = null;
            return temp;
        }
        int loopStart = i;
        int loopEnd = size - 1;
        E temp = data[i];
        data[size - 1] = null;
        for (int start = loopStart; start < loopEnd; start++) {
            data[start] = data[start - 1];
        }
        return temp;
    }
}
