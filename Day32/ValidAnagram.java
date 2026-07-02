package Day32;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        // Length check
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        // Count characters
        for (int i = 0; i < s.length(); i++) {

            freq[s.charAt(i) - 'a']++;

            freq[t.charAt(i) - 'a']--;
        }

        // Check frequencies
        for (int count : freq) {

            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}