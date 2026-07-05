package Day35;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PPI_traversal {
    
    public class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
    class Pair {

        TreeNode node;
        int state;

        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    List<List<Integer>> treeTraversal(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {

            ans.add(inorder);
            ans.add(preorder);
            ans.add(postorder);

            return ans;
        }

        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {

            Pair curr = stack.pop();

            // Preorder
            if (curr.state == 1) {

                preorder.add(curr.node.data);

                curr.state++;

                stack.push(curr);

                if (curr.node.left != null) {
                    stack.push(new Pair(curr.node.left, 1));
                }
            }

            // Inorder
            else if (curr.state == 2) {

                inorder.add(curr.node.data);

                curr.state++;

                stack.push(curr);

                if (curr.node.right != null) {
                    stack.push(new Pair(curr.node.right, 1));
                }
            }

            // Postorder
            else {

                postorder.add(curr.node.data);
            }
        }

        ans.add(inorder);
        ans.add(preorder);
        ans.add(postorder);

        return ans;
    }
}
