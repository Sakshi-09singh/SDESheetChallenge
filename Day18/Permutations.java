package Day18;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));  // Add the current permutation to result
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // Skip if the element is already in the tempList
                tempList.add(nums[i]);                   // Choose the element
                backtrack(result, tempList, nums);       // Explore further with the current choice
                tempList.remove(tempList.size() - 1);    // Undo the choice (backtrack)
            }
        }
    }
}
