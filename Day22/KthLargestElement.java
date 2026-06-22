package Day22;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int kthLargestElement(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {

            pq.offer(num);

            // Keep only k largest elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
