public class DDLinkedList<E> implements List<E> {

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
    private Node curr;
    private int size;
    private int pos;

    public DDLinkedList() {
        head = null;
        tail = null;
        curr = null;
        size = 0;
        pos = 0;
    }

    public void clear() {
        head = null;
        tail = null;
        curr = null;
        size = 0;
        pos = 0;
    }

    public void insert(E item) {
        Node node = new Node(item);

        if (curr == null) {
            node.prev = tail;

            if (tail != null) {
                tail.next = node;
            } else {
                head = node;
            }

            tail = node;
        } else {
            node.next = curr;
            node.prev = curr.prev;

            if (curr.prev != null) {
                curr.prev.next = node;
            } else {
                head = node;
            }

            curr.prev = node;
        }

        curr = node;
        size++;
    }

    public void append(E item) {
        Node node = new Node(item);
        node.prev = tail;

        if (tail != null) {
            tail.next = node;
        } else {
            head = node;
        }

        tail = node;
        size++;

        if (pos == size - 1) {
            curr = node;
        }
    }

    public E remove() {
        if (curr == null) {
            return null;
        }

        E value = curr.data;
        Node nextNode = curr.next;

        if (curr.prev != null) {
            curr.prev.next = curr.next;
        } else {
            head = curr.next;
        }

        if (curr.next != null) {
            curr.next.prev = curr.prev;
        } else {
            tail = curr.prev;
        }

        size--;
        curr = nextNode;

        if (curr == null) {
            pos = size;
        }

        return value;
    }

    public void moveToStart() {
        curr = head;
        pos = 0;
    }

    public void moveToEnd() {
        curr = null;
        pos = size;
    }

    public void prev() {
        if (pos > 0) {
            if (curr == null) {
                curr = tail;
            } else {
                curr = curr.prev;
            }
            pos--;
        }
    }

    public void next() {
        if (curr != null) {
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

        pos = position;
        curr = head;

        for (int i = 0; i < position && curr != null; i++) {
            curr = curr.next;
        }
    }

    public E getValue() {
        if (curr == null) {
            return null;
        }

        return curr.data;
    }
}
