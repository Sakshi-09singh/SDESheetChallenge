package Day19;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return solve(0, s, set, dp);
    }
    private boolean solve(int index,String s,Set<String> set,Boolean[] dp) {
        // Reached end
        if (index == s.length())
            return true;

        // Already solved
        if (dp[index] != null)
            return dp[index];

        for (int end = index + 1; end <= s.length(); end++) {

            String word = s.substring(index, end);

            if (set.contains(word) &&
                solve(end, s, set, dp)) {

                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }
}
