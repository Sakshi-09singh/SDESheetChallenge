package Day26;

import java.util.Stack;
public class NextGreaterElement {
    public int[] nextSmallerElements(int[] arr) {

        int n = arr.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove greater or equal elements
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // Next smaller element
            ans[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return ans;
    }
}