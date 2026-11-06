public class CDLinkedList<E> implements List<E> {

    private class Node {
        E data;
        Node prev;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private Node curr;
    private int size;
    private int pos;

    public CDLinkedList() {
        head = new Node(null);
        head.next = head;
        head.prev = head;

        curr = head;
        size = 0;
        pos = 0;
    }

    public void clear() {
        head.next = head;
        head.prev = head;
        curr = head;
        size = 0;
        pos = 0;
    }

    public void insert(E item) {
        Node node = new Node(item);

        node.prev = curr;
        node.next = curr.next;

        curr.next.prev = node;
        curr.next = node;

        size++;
    }

    public void append(E item) {
        Node node = new Node(item);

        node.prev = head.prev;
        node.next = head;

        head.prev.next = node;
        head.prev = node;

        size++;
    }

    public E remove() {
        if (curr.next == head) {
            return null;
        }

        Node node = curr.next;
        E value = node.data;

        curr.next = node.next;
        node.next.prev = curr;

        size--;
        return value;
    }

    public void moveToStart() {
        curr = head;
        pos = 0;
    }

    public void moveToEnd() {
        curr = head.prev;
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
        if (curr.next == head) {
            return null;
        }

        return curr.next.data;
    }
}
