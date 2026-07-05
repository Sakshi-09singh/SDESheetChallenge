package Day35;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VOT_BT {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Tuple {

        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // col -> row -> minHeap(values)
        TreeMap<Integer,
        TreeMap<Integer,
        PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();

        queue.offer(new Tuple(root, 0, 0));

        // BFS Traversal
        while (!queue.isEmpty()) {

            Tuple curr = queue.poll();

            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            map.putIfAbsent(col, new TreeMap<>());

            map.get(col)
               .putIfAbsent(row,
               new PriorityQueue<>());

            map.get(col)
               .get(row)
               .offer(node.val);

            if (node.left != null) {

                queue.offer(
                    new Tuple(node.left,
                              row + 1,
                              col - 1)
                );
            }

            if (node.right != null) {

                queue.offer(
                    new Tuple(node.right,
                              row + 1,
                              col + 1)
                );
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        // Build answer
        for (TreeMap<Integer,
             PriorityQueue<Integer>> rows
             : map.values()) {

            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq
                 : rows.values()) {

                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            ans.add(list);
        }

        return ans;
    }
}
