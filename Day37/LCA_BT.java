package Day37;
public class LCA_BT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p,
                                         TreeNode q) {

        // Base case
        if (root == null ||
            root == p ||
            root == q) {

            return root;
        }

        TreeNode left =
            lowestCommonAncestor(root.left, p, q);

        TreeNode right =
            lowestCommonAncestor(root.right, p, q);

        // Both found
        if (left != null && right != null) {
            return root;
        }

        // Return non-null side
        return (left != null) ? left : right;
    }
}