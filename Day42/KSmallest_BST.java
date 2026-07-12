package Day42;

public class KSmallest_BST {
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

    int count = 0;
    int ans = 0;

    public int kthSmallest(TreeNode root, int k) {

        inorder(root, k);

        return ans;
    }

    private void inorder(TreeNode node, int k) {

        if (node == null) {
            return;
        }

        inorder(node.left, k);

        count++;

        if (count == k) {
            ans = node.val;
            return;
        }

        inorder(node.right, k);
    }
}