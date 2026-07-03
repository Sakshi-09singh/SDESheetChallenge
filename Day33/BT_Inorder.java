package Day33;

import java.util.*;
public class BT_Inorder {
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

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        // Iterative Inorder Traversal
        while (curr != null || !stack.isEmpty()) {

            // Traverse left subtree
            while (curr != null) {

                stack.push(curr);

                curr = curr.left;
            }

            curr = stack.pop();

            ans.add(curr.val);

            // Move to right subtree
            curr = curr.right;
        }

        return ans;
    }
}