package Day17;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequences {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        // store numbers and calculate factorial
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }

        numbers.add(n);

        // convert to 0-based indexing
        k = k - 1;

        StringBuilder ans = new StringBuilder();

        while (true) {

            // choose index
            ans.append(numbers.get(k / fact));

            // remove used number
            numbers.remove(k / fact);

            // if no numbers left
            if (numbers.size() == 0) {
                break;
            }

            // update k
            k = k % fact;

            // update factorial
            fact = fact / numbers.size();
        }

        return ans.toString();
    }
}
