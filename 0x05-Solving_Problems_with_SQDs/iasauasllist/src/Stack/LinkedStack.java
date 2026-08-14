package Stack;

public class LinkedStack<E> implements Stack<E> {

    // Member variables
    private SinglyLinkedList list = new SinglyLinkedList<>();

    // ------------------- Member methods -------------------
    @Override
    public int size() {

        return list.size();
    }

    @Override
    public boolean isEmpty() {

        return list.isEmpty();
    }

    // ------------------- Access methods -------------------
    @Override
    public E top() {
        return (E) list.getFirst();
    }

    // ------------------- Update methods -------------------
    @Override
    public void push(E e) {

        list.addFirst(e);
    }

    @Override
    public E pop() {

        return (E) list.removeFirst();
    }
}
