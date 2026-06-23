package Day23;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {
    // Max Heap for left half
    PriorityQueue<Integer> maxHeap;

    // Min Heap for right half
    PriorityQueue<Integer> minHeap;

    public void MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Add to maxHeap
        maxHeap.offer(num);

        // Step 2: Move largest from maxHeap to minHeap
        minHeap.offer(maxHeap.poll());

        // Step 3: Balance heaps
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        // If sizes equal -> average
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        // Otherwise top of maxHeap
        return maxHeap.peek();
    }
}
