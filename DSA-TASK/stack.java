public interface Stack<E> {
    void clear();
    void push(E item);
    E pop();
    E top();
    int length();
    boolean isEmpty();
}
