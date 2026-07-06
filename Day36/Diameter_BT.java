package Day36;

public class Diameter_BT {
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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);

        return diameter;
    }

    public int height(TreeNode root)
    {
        // Base case
        if(root == null)
        {
            return 0;
        }

        // Left subtree height
        int left = height(root.left);

        // Right subtree height
        int right = height(root.right);

        // Update diameter
        diameter = Math.max(diameter, left + right);

        // Return height
        return 1 + Math.max(left, right);
    }
}