package Day27;

import java.util.Stack;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() &&
                   heights[stack.peek()] > currHeight) {

                int height = heights[stack.pop()];

                int right = i;

                int left = stack.isEmpty()
                           ? -1
                           : stack.peek();

                int width = right - left - 1;

                maxArea = Math.max(maxArea,
                                   height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}