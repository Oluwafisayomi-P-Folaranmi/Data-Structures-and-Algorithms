import LinkedDeque.LinkedDeque;

public class Main {
    public static void main(String[] args) {
        LinkedDeque<Integer> integerLinkedDeque;
        integerLinkedDeque = new LinkedDeque<Integer>();
        integerLinkedDeque.size();
        integerLinkedDeque.isEmpty();
        Integer first = integerLinkedDeque.first();
        Integer last = integerLinkedDeque.last();
        integerLinkedDeque.addFirst(4);
        integerLinkedDeque.addLast(5);
        integerLinkedDeque.removeFirst();
        integerLinkedDeque.removeLast();
    }
}
