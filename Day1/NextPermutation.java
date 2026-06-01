package Day1;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int i = n - 1;

        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }

        if (i != 0) {
            int index = i;

            for (int j = n - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    index = j;
                    break;
                }
            }

            // Swap
            int temp = nums[i - 1];
            nums[i - 1] = nums[index];
            nums[index] = temp;
        }

        // Reverse the remaining array
        reverse(nums, i, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}