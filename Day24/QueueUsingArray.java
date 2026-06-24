public class QueueUsingArray {
     int[] queue;
    int front;
    int rear;

    public void ArrayQueue() {
        queue = new int[100];
        front = 0;
        rear = -1;
    }

    // Add element to queue
    public void push(int x) {
        rear++;
        queue[rear] = x;
    }

    // Remove and return front element
    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int val = queue[front];
        front++;
        return val;
    }

    // Return front element without removing
    public int peek() {
        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front > rear;
    }
}
