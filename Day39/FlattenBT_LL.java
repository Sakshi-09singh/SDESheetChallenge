package Day39;

public class FlattenBT_LL {
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
    TreeNode prev = null;

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        // Traverse right subtree first
        flatten(root.right);

        // Traverse left subtree
        flatten(root.left);

        // Rearrange pointers
        root.right = prev;
        root.left = null;

        // Move prev to current node
        prev = root;
    }
}
