public class NLinkedStack<E> implements Stack<E> {

    private class Node {
        E data;
        Node prev;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public NLinkedStack() {
        head = null;
        tail = null;
        size = 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void push(E item) {
        Node node = new Node(item);

        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }

        E item = tail.data;
        tail = tail.prev;

        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }

        size--;
        return item;
    }

    public E top() {
        if (isEmpty()) {
            return null;
        }

        return tail.data;
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
