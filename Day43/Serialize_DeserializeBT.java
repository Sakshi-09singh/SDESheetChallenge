package Day43;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize_DeserializeBT {

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
    // Serialize
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("N,");
                continue;
            }

            sb.append(node.val).append(",");

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return sb.toString();
    }

    // Deserialize
    public TreeNode deserialize(String data) {

        if (data.length() == 0) {
            return null;
        }

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty()) {

            TreeNode parent = queue.poll();

            // Left child
            if (!values[i].equals("N")) {

                parent.left = new TreeNode(Integer.parseInt(values[i]));

                queue.offer(parent.left);
            }

            i++;

            // Right child
            if (!values[i].equals("N")) {

                parent.right = new TreeNode(Integer.parseInt(values[i]));

                queue.offer(parent.right);
            }

            i++;
        }

        return root;
    }
}




// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));