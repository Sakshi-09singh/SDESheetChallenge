import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public void MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push element onto stack
    public void push(int x) {
        q2.offer(x);

        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    // Remove and return top element
    public int pop() {
        return q1.poll();
    }
    
    // Return top element
    public int top() {
        return q1.peek();
    }
    
    // Check if stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }
}
