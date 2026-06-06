import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    // Function to count reverse pairs during merge
    static int merging(int[] nums, int low, 
                                int mid, int high) {
                                
        int count = 0, j = mid + 1;

        // Count valid pairs before merging
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // Merge step (standard merge sort)
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) {
            temp.add(nums[left++]);
        }

        while (right <= high) {
            temp.add(nums[right++]);
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }

        return count;
    }

    // Function to perform merge sort and count pairs
    static int mergeSort(int[] nums, int low, int high) {
        
        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int count = mergeSort(nums, low, mid) + 
                    mergeSort(nums, mid + 1, high) +
                    merging(nums, low, mid, high);

        return count;
    }

    // Function to count reverse pairs
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
