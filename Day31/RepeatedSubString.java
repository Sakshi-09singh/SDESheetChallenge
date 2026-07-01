package Day31;

public class RepeatedSubString {
    public boolean repeatedSubstringPattern(String s) {
        
        int n = s.length();

        // Check every possible substring length
        for (int i = 1; i <= n / 2; i++) {

            // Substring length must divide total length
            if (n % i == 0) {

                String part = s.substring(0, i);
                StringBuilder sb = new StringBuilder();

                int repeat = n / i;

                // Repeat substring
                for (int j = 0; j < repeat; j++) {
                    sb.append(part);
                }

                // Compare with original string
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }
}
