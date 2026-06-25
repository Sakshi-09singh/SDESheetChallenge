package Day25;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Find next greater for nums2
        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            int nextGreater = stack.isEmpty() ? -1 : stack.peek();

            map.put(nums2[i], nextGreater);

            stack.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        // Fill answer for nums1
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
