public class LinkedStack<E> implements Stack<E> {

    private class Node {
        E data;
        Node next;

        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public void push(E item) {
        top = new Node(item, top);
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }

        E item = top.data;
        top = top.next;
        size--;

        return item;
    }

    public E top() {
        if (isEmpty()) {
            return null;
        }

        return top.data;
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
