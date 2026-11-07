public interface Queue<E> {
    void clear();
    void enqueue(E item);
    E dequeue();
    E front();
    int length();
    boolean isEmpty();
}
