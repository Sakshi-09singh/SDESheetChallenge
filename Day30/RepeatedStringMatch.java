package Day30;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int count = 0;

        // Repeat until length >= b.length()
        while (sb.length() < b.length()) {

            sb.append(a);

            count++;
        }

        // Check current repetition
        if (sb.indexOf(b) != -1) {
            return count;
        }

        // One more repetition may be needed
        sb.append(a);

        if (sb.indexOf(b) != -1) {
            return count + 1;
        }

        return -1;
    }
}
