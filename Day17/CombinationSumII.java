package Day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates); // sort to handle duplicates

        backtrack(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    public void backtrack(int index, int[] arr, int target,List<Integer> temp, List<List<Integer>> ans) {

        // base case
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // skip duplicates
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            // if number becomes greater than target
            if (arr[i] > target) {
                break;
            }

            // choose
            temp.add(arr[i]);

            // move to next index because one element can be used once only
            backtrack(i + 1, arr, target - arr[i], temp, ans);

            // backtrack
            temp.remove(temp.size() - 1);
        }
    }
}
