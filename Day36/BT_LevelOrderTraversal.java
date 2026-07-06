package Day36;

import java.util.*;

public class BT_LevelOrderTraversal{
     
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        // Edge case
        if(root == null)
        {
            return ans;
        }

        // Queue for BFS
        Queue<TreeNode> q = new LinkedList<>();

        // Add root
        q.offer(root);

        // BFS traversal
        while(!q.isEmpty())
        {
            int size = q.size();

            // Store one level
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++)
            {
                TreeNode current = q.poll();

                level.add(current.val);

                // Left child
                if(current.left != null)
                {
                    q.offer(current.left);
                }

                // Right child
                if(current.right != null)
                {
                    q.offer(current.right);
                }
            }

            // Add level to answer
            ans.add(level);
        }

        return ans;
    }
}