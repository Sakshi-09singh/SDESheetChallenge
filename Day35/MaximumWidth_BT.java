package Day35;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth_BT {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right; 
        }
    }
    class Pair {

        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int maxWidth = 0;

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        // Level Order Traversal
        while (!queue.isEmpty()) {

            int size = queue.size();

            long minIndex = queue.peek().index;

            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {

                Pair curr = queue.poll();

                long currIndex =
                    curr.index - minIndex;

                TreeNode node = curr.node;

                if (i == 0) {
                    first = currIndex;
                }

                if (i == size - 1) {
                    last = currIndex;
                }

                if (node.left != null) {

                    queue.offer(
                        new Pair(node.left,
                                 2 * currIndex + 1)
                    );
                }

                if (node.right != null) {

                    queue.offer(
                        new Pair(node.right,
                                 2 * currIndex + 2)
                    );
                }
            }

            maxWidth =
                Math.max(maxWidth,
                         (int)(last - first + 1));
        }

        return maxWidth;
    }
}
