
import java.util.Arrays;
class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Fill with a large value
        Arrays.fill(dp, amount + 1);

        // Base case
        dp[0] = 0;

        // Build DP array
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If not possible
        return dp[amount] > amount ? -1 : dp[amount];
    }
}