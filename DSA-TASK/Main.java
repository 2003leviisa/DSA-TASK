public class Main {

    public static void main(String[] args) {

        System.out.println("=== LINKED LIST TEST ===");

        List<Integer> list = new DLinkedList<>();

        list.append(10);
        list.append(20);
        list.append(30);

        list.moveToStart();
        System.out.println("First element: " + list.getValue());

        list.next();
        System.out.println("Second element: " + list.getValue());

        System.out.println("List length: " + list.length());


        System.out.println("\n=== STACK TEST ===");

        Stack<Integer> stack = new ArrayStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top());
        System.out.println("Removed: " + stack.pop());
        System.out.println("New top: " + stack.top());


        System.out.println("\n=== LINKED STACK TEST ===");

        Stack<Integer> linkedStack = new LinkedStack<>();

        linkedStack.push(5);
        linkedStack.push(15);
        linkedStack.push(25);

        System.out.println("Top element: " + linkedStack.top());
        System.out.println("Removed: " + linkedStack.pop());


        System.out.println("\n=== N LINKED STACK TEST ===");

        Stack<Integer> nStack = new NLinkedStack<>();

        nStack.push(100);
        nStack.push(200);
        nStack.push(300);

        System.out.println("Top element: " + nStack.top());
        System.out.println("Removed: " + nStack.pop());


        System.out.println("\n=== LINKED QUEUE TEST ===");

        Queue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.front());
        System.out.println("Removed: " + queue.dequeue());


        System.out.println("\n=== LINKED QUEUE 2 TEST ===");

        Queue<Integer> queue2 = new LinkedQueue2<>();

        queue2.enqueue(10);
        queue2.enqueue(20);
        queue2.enqueue(30);

        System.out.println("Front element: " + queue2.front());
        System.out.println("Removed: " + queue2.dequeue());


        System.out.println("\n=== ARRAY QUEUE TEST ===");

        Queue<Integer> arrayQueue = new ArrayQueue<>();

        arrayQueue.enqueue(100);
        arrayQueue.enqueue(200);
        arrayQueue.enqueue(300);

        System.out.println("Front element: " + arrayQueue.front());
        System.out.println("Removed: " + arrayQueue.dequeue());


        System.out.println("\n=== CIRCULAR LINKED LIST TEST ===");

        List<Integer> circularList = new CDLinkedList<>();

        circularList.append(1);
        circularList.append(2);
        circularList.append(3);

        circularList.moveToStart();

        System.out.println("First element: " + circularList.getValue());

        circularList.next();

        System.out.println("Second element: " + circularList.getValue());


        System.out.println("\n=== DOUBLY LINKED LIST TEST ===");

        List<Integer> doubleList = new DDLinkedList<>();

        doubleList.append(50);
        doubleList.append(60);
        doubleList.append(70);

        doubleList.moveToStart();

        System.out.println("First element: " + doubleList.getValue());

        System.out.println("\nAll basic tests completed.");
    }
}
