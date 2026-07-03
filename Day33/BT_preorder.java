package Day33;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BT_preorder {
    //   Definition for a binary tree node.
    class TreeNode {
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

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        // Iterative Preorder Traversal
        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            ans.add(node.val);

            // Push right first
            if (node.right != null) {
                stack.push(node.right);
            }

            // Push left second
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return ans;
    }
}
