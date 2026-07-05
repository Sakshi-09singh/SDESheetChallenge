package Day35;

import java.util.ArrayList;
import java.util.List;

public class PrintRootLeaf_BT {
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
    public List<List<Integer>> allRootToLeaf(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        dfs(root, path, ans);

        return ans;
    }

    private void dfs(TreeNode node,
                     List<Integer> path,
                     List<List<Integer>> ans) {

        if (node == null) {
            return;
        }

        path.add(node.data);

        // Leaf node
        if (node.left == null &&
            node.right == null) {

            ans.add(new ArrayList<>(path));
        }

        dfs(node.left, path, ans);

        dfs(node.right, path, ans);

        // Backtrack
        path.remove(path.size() - 1);
    }
}
