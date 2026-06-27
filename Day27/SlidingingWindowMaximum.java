package Day27;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            // Remove indices out of current window
            while (!dq.isEmpty() &&
                   dq.peekFirst() <= i - k) {

                dq.pollFirst();
            }

            // Remove smaller elements
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] < nums[i]) {

                dq.pollLast();
            }

            dq.offerLast(i);

            // Store answer
            if (i >= k - 1) {
                ans[index++] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}
