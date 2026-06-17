package Day17;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
    public List<List<String>> partition(String s) {
        //your code goes here
         List<List<String>> ans = new ArrayList<>();

        backtrack(0, s, new ArrayList<>(), ans);

        return ans;
    }

    public void backtrack(int index, String s,
                          List<String> temp,
                          List<List<String>> ans) {

        // if reached end of string
        if (index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // try every possible substring
        for (int i = index; i < s.length(); i++) {

            // check palindrome
            if (isPalindrome(s, index, i)) {

                // take substring
                temp.add(s.substring(index, i + 1));

                // recursive call
                backtrack(i + 1, s, temp, ans);

                // backtrack
                temp.remove(temp.size() - 1);
            }
        }
    }

    // palindrome check
    public boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
