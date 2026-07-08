package Day38;

import java.util.HashMap;

public class BT_InorderAndPost {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1,
                     map);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd,
                           HashMap<Integer, Integer> map) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // Last element of postorder is the root
        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(root.val);

        int numsLeft = inRoot - inStart;

        root.left = build(inorder,
                          inStart,
                          inRoot - 1,
                          postorder,
                          postStart,
                          postStart + numsLeft - 1,
                          map);

        root.right = build(inorder,
                           inRoot + 1,
                           inEnd,
                           postorder,
                           postStart + numsLeft,
                           postEnd - 1,
                           map);

        return root;
    }
}
