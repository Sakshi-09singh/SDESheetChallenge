package Day21;

public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;

        // Merge both sorted arrays
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Copy remaining elements from nums1
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        // Copy remaining elements from nums2
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        int totalLength = m + n;

        // If even number of elements, median is average of middle two
        if (totalLength % 2 == 0) {
            return (merged[totalLength / 2 - 1] + merged[totalLength / 2]) / 2.0;
        } 
        // If odd, median is middle element
        else {
            return merged[totalLength / 2];
        }
    }
}
