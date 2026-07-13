package Day43;

public class MaxSumBST {

    public class TreeNode {
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
    class NodeInfo {

        boolean isBST;
        int min;
        int max;
        int sum;

        NodeInfo(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {

        dfs(root);

        return maxSum;
    }

    private NodeInfo dfs(TreeNode node) {

        // Empty tree is a valid BST
        if (node == null) {
            return new NodeInfo(true,
                                Integer.MAX_VALUE,
                                Integer.MIN_VALUE,
                                0);
        }

        NodeInfo left = dfs(node.left);
        NodeInfo right = dfs(node.right);

        // Current subtree is a BST
        if (left.isBST &&
            right.isBST &&
            node.val > left.max &&
            node.val < right.min) {

            int sum = left.sum + right.sum + node.val;

            maxSum = Math.max(maxSum, sum);

            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);

            return new NodeInfo(true, min, max, sum);
        }

        // Not a BST
        return new NodeInfo(false, 0, 0, 0);
    }
}
