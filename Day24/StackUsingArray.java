public class StackUsingArray {
     int[] stack;
    int top;

    public void ArrayStack() {
        stack = new int[100];
        top = -1;
    }

    // Push element into stack
    public void push(int x) {
        top++;
        stack[top] = x;
    }

    // Remove and return top element
    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int val = stack[top];
        top--;
        return val;
    }

    // Return top element without removing
    public int top() {
        if (isEmpty()) {
            return -1;
        }

        return stack[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}
