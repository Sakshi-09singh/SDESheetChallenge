package Day31;

public class Index1Occurence {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // Traverse haystack
        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            // Compare characters
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // Full match found
            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}
