import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public void MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    // Push element to back of queue
    public void push(int x) {
        s1.push(x);
    }
    
    // Remove and return front element
    public int pop() {

        // Transfer elements if s2 is empty
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }
    
    // Return front element
    public int peek() {

        // Transfer elements if s2 is empty
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }
    
    // Check if queue is empty
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
