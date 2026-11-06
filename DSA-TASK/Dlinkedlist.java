public class DLinkedList<E> implements List<E> {

    private class Node {
        E data;
        Node prev;
        Node next;

        Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private Node curr;
    private int size;
    private int pos;

    public DLinkedList() {
        head = new Node(null, null, null);
        tail = head;
        curr = head;
        size = 0;
        pos = 0;
    }

    public void clear() {
        head.next = null;
        tail = head;
        curr = head;
        size = 0;
        pos = 0;
    }

    public void insert(E item) {
        Node node = new Node(item, curr, curr.next);

        if (curr.next != null) {
            curr.next.prev = node;
        } else {
            tail = node;
        }

        curr.next = node;
        size++;
    }

    public void append(E item) {
        Node node = new Node(item, tail, null);
        tail.next = node;
        tail = node;
        size++;
    }

    public E remove() {
        if (curr.next == null) {
            return null;
        }

        Node node = curr.next;
        curr.next = node.next;

        if (node.next != null) {
            node.next.prev = curr;
        } else {
            tail = curr;
        }

        size--;
        return node.data;
    }

    public void moveToStart() {
        curr = head;
        pos = 0;
    }

    public void moveToEnd() {
        curr = tail;
        pos = size;
    }

    public void prev() {
        if (pos > 0) {
            curr = curr.prev;
            pos--;
        }
    }

    public void next() {
        if (pos < size) {
            curr = curr.next;
            pos++;
        }
    }

    public int length() {
        return size;
    }

    public int currPos() {
        return pos;
    }

    public void moveToPos(int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        curr = head;
        pos = 0;

        while (pos < position) {
            curr = curr.next;
            pos++;
        }
    }

    public E getValue() {
        if (curr.next == null) {
            return null;
        }

        return curr.next.data;
    }
}
