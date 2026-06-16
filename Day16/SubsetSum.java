public class SubsetSum {
    public boolean isSubsetSum(int[] arr, int target) {
      int n = arr.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // Sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= target; j++) {

                // Not take current element
                dp[i][j] = dp[i - 1][j];

                // Take current element if possible
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][target];
    }
}


