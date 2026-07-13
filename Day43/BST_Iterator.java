package Day43;

import java.util.Stack;

public class BST_Iterator {
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


    
     private Stack<TreeNode> stack;
     private Object root;

    public void BSTIterator(TreeNode root) {

        stack = new Stack<>();

        pushAllLeft(root);
    }

    public int next() {

        TreeNode node = stack.pop();

        // Push all left nodes of right subtree
        pushAllLeft(node.right);

        return node.val;
    }

    public boolean hasNext() {

        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode node) {

        while (node != null) {

            stack.push(node);

            node = node.left;
        }
    }
}


// BSTIterator obj = new BSTIterator(root);
// int param_1 = obj.next();
//  boolean param_2 = obj.hasNext();
