package Day37;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public List<Integer> boundary(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        if (!isLeaf(root)) {
            ans.add(root.data);
        }

        addLeftBoundary(root, ans);

        addLeaves(root, ans);

        addRightBoundary(root, ans);

        return ans;
    }

    private boolean isLeaf(TreeNode node) {

        return node.left == null &&
               node.right == null;
    }

    private void addLeftBoundary(TreeNode root,
                                 List<Integer> ans) {

        TreeNode curr = root.left;

        while (curr != null) {

            if (!isLeaf(curr)) {
                ans.add(curr.data);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private void addLeaves(TreeNode root,
                           List<Integer> ans) {

        if (isLeaf(root)) {

            ans.add(root.data);

            return;
        }

        if (root.left != null) {
            addLeaves(root.left, ans);
        }

        if (root.right != null) {
            addLeaves(root.right, ans);
        }
    }

    private void addRightBoundary(TreeNode root,
                                  List<Integer> ans) {

        TreeNode curr = root.right;

        Stack<Integer> stack = new Stack<>();

        while (curr != null) {

            if (!isLeaf(curr)) {
                stack.push(curr.data);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        while (!stack.isEmpty()) {

            ans.add(stack.pop());
        }
    }
}
