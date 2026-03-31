import java.util.Stack;

public class ImplementQueueUsingStack {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    public static void enqueue(int x) {
        stack1.push(x);
        System.out.println(stack1);
    }

    public static int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);

        System.out.println("Dequeued: " + dequeue());
        System.out.println("Dequeued: " + dequeue());

        enqueue(40);

        System.out.println("Dequeued: " + dequeue());
    }
}
