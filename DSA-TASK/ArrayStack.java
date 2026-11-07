public class ArrayStack<E> implements Stack<E> {

    private E[] stack;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        capacity = 10;
        stack = (E[]) new Object[capacity];
        top = 0;
    }

    public void clear() {
        for (int i = 0; i < top; i++) {
            stack[i] = null;
        }

        top = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        E[] newStack = (E[]) new Object[capacity];

        for (int i = 0; i < top; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
    }

    public void push(E item) {
        if (top == capacity) {
            resize();
        }

        stack[top] = item;
        top++;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }

        top--;
        E item = stack[top];
        stack[top] = null;

        return item;
    }

    public E top() {
        if (isEmpty()) {
            return null;
        }

        return stack[top - 1];
    }

    public int length() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }
}
