package Day15;

public class Mini_No_platforms {
    public int findPlatform(int arr[], int dep[], int n) {
        // Sort arrival and departure times
        java.util.Arrays.sort(arr);
        java.util.Arrays.sort(dep);

        int platform_needed = 1, result = 1;
        int i = 1, j = 0;

        // Similar to merge in merge sort to process all events in sorted order
        while (i < n && j < n) {
            // If next event is arrival, increment count of platforms needed
            if (arr[i] <= dep[j]) {
                platform_needed++;
                i++;
            }
            // Else decrement count of platforms needed
            else {
                platform_needed--;
                j++;
            }
            // Update result if needed
            result = Math.max(result, platform_needed);
        }

        return result;
    }
}