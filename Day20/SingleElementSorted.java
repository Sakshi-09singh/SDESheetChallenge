package Day20;

public class SingleElementSorted {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // Binary Search
        while (low < high) {

            int mid = low + (high - low) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            // Pair is correct
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } 
            // Single element is on left side
            else {
                high = mid;
            }
        }

        return nums[low];
    }
}
