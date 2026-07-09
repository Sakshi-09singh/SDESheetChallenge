package Day39;

public class ChildrenSum_BT {

    class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
    boolean checkChildrenSum(TreeNode root) {

        // Empty tree or leaf node
        if (root == null ||
            (root.left == null && root.right == null)) {
            return true;
        }

        int left = 0;
        int right = 0;

        if (root.left != null) {
            left = root.left.val;
        }

        if (root.right != null) {
            right = root.right.val;
        }

        // Check current node and recursively check subtrees
        return (root.val == left + right)
                && checkChildrenSum(root.left)
                && checkChildrenSum(root.right);
    }
}
