package Day41;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor_Preorder {
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    

    List<Integer> succPredBST(TreeNode root, int key) {

        int pred = -1;
        int succ = -1;

        TreeNode curr = root;

        // Find predecessor
        while (curr != null) {

            if (key > curr.data) {
                pred = curr.data;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        curr = root;

        // Find successor
        while (curr != null) {

            if (key < curr.data) {
                succ = curr.data;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(pred);
        ans.add(succ);

        return ans;
    }
}
    

