public class LinkedQueue<E> implements Queue<E> {

    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(E item) {
        Node node = new Node(item);

        if (rear == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }

        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E item = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        return item;
    }

    public E front() {
        if (isEmpty()) {
            return null;
        }

        return front.data;
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
