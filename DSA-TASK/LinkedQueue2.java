public class LinkedQueue2<E> implements Queue<E> {

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

    public LinkedQueue2() {
        head = null;
        tail = null;
        size = 0;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(E item) {
        Node node = new Node(item);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        size++;
    }

    public E dequeue() {
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

    public E front() {
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
