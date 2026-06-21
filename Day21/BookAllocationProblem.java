package Day21;

public class BookAllocationProblem {
    public int findPages(int[] nums, int m) {
        int n = nums.length;

        // Not possible if students are more than books
        if (m > n) {
            return -1;
        }

        int low = 0;
        int high = 0;

        // low = max element
        // high = sum of all pages
        for (int pages : nums) {
            low = Math.max(low, pages);
            high += pages;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int students = countStudents(nums, mid);

            // Possible allocation
            if (students <= m) {
                high = mid - 1;
            } 
            // Need more pages
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int countStudents(int[] nums, int maxPages) {

        int students = 1;
        int pages = 0;

        for (int num : nums) {

            if (pages + num <= maxPages) {
                pages += num;
            } else {
                students++;
                pages = num;
            }
        }

        return students;
    }
}
