public class ArrayQueue<E> implements Queue<E> {

    private E[] queue;
    private int front;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        capacity = 10;
        queue = (E[]) new Object[capacity];
        front = 0;
        size = 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            queue[(front + i) % capacity] = null;
        }

        front = 0;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        E[] newQueue = (E[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }

        queue = newQueue;
        front = 0;
    }

    public void enqueue(E item) {
        if (size == capacity) {
            resize();
        }

        int rear = (front + size) % capacity;
        queue[rear] = item;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        E item = queue[front];
        queue[front] = null;

        front = (front + 1) % capacity;
        size--;

        if (size == 0) {
            front = 0;
        }

        return item;
    }

    public E front() {
        if (isEmpty()) {
            return null;
        }

        return queue[front];
    }

    public int length() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
