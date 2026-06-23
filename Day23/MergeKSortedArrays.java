package Day23;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public List<Integer> mergeKSortedArrays(int[][] arr, int k) {

        List<Integer> result = new ArrayList<>();

        // Min Heap based on value
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.value - b.value
        );

        // Insert first element of every row
        for (int i = 0; i < k; i++) {
            pq.offer(new Node(arr[i][0], i, 0));
        }

        // Process heap
        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            result.add(curr.value);

            int row = curr.row;
            int col = curr.col;

            // Push next element from same row
            if (col + 1 < k) {
                pq.offer(new Node(arr[row][col + 1], row, col + 1));
            }
        }

        return result;
    }
}
