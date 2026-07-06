package Day36;
public class MaxDepth_BT {

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
    public int maxDepth(TreeNode root) {
        // Base case
        if(root == null)
        {
            return 0;
        }
        
        // Left subtree depth
        int leftDepth = maxDepth(root.left);

        // Right subtree depth
        int rightDepth = maxDepth(root.right);

        // Return maximum depth
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
