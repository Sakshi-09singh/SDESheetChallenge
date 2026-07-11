package Day41;

public class ValidateBST {

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
    public boolean isValidBST(TreeNode root) {

        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        // Current node must lie within the valid range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left subtree: values < node.val
        // Right subtree: values > node.val
        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }
}
