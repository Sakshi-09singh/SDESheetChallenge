package Day36;

public class BalancedBT {
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
    public boolean isBalanced(TreeNode root) {

        return height(root) != -1;
    }

    public int height(TreeNode root)
    {
        // Base case
        if(root == null)
        {
            return 0;
        }

        // Left height
        int left = height(root.left);

        // Left subtree already unbalanced
        if(left == -1)
        {
            return -1;
        }

        // Right height
        int right = height(root.right);

        // Right subtree already unbalanced
        if(right == -1)
        {
            return -1;
        }

        // Current node unbalanced
        if(Math.abs(left - right) > 1)
        {
            return -1;
        }

        // Return height
        return 1 + Math.max(left, right);
    }
}
