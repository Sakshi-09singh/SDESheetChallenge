package Day33;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BT_postorder {
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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        // Reverse preorder traversal
        while (!stack1.isEmpty()) {

            TreeNode node = stack1.pop();

            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        // Get postorder
        while (!stack2.isEmpty()) {

            ans.add(stack2.pop().val);
        }

        return ans;
    }
}
