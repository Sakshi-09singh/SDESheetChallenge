package Day22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MaxSubCombination {
    static class Tuple {
        int sum;
        int i;
        int j;

        Tuple(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        PriorityQueue<Tuple> maxHeap =
            new PriorityQueue<>((a, b) -> b.sum - a.sum);

        HashSet<String> visited = new HashSet<>();

        int i = n - 1;
        int j = n - 1;

        maxHeap.offer(new Tuple(nums1[i] + nums2[j], i, j));
        visited.add(i + "#" + j);

        int[] ans = new int[k];
        int index = 0;

        while (index < k) {

            Tuple curr = maxHeap.poll();

            ans[index++] = curr.sum;

            int x = curr.i;
            int y = curr.j;

            // Move left
            if (x - 1 >= 0 &&
                !visited.contains((x - 1) + "#" + y)) {

                maxHeap.offer(
                    new Tuple(nums1[x - 1] + nums2[y], x - 1, y)
                );

                visited.add((x - 1) + "#" + y);
            }

            // Move up
            if (y - 1 >= 0 &&
                !visited.contains(x + "#" + (y - 1))) {

                maxHeap.offer(
                    new Tuple(nums1[x] + nums2[y - 1], x, y - 1)
                );

                visited.add(x + "#" + (y - 1));
            }
        }

        return ans;
    }
}
