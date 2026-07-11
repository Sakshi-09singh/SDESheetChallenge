package Day41;

public class LCA_BST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        
    }

    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p,
                                         TreeNode q) {

        while (root != null) {

            // Both nodes are in the left subtree
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // Both nodes are in the right subtree
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // Split point (or one node is the root)
            else {
                return root;
            }
        }

        return null;
    }

}
