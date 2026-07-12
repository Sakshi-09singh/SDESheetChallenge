package Day42;

import java.util.ArrayList;
import java.util.List;

public class FloorCeil_BST {

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
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {

        int floor = -1;
        int ceil = -1;

        TreeNode curr = root;

        // Find Floor
        while (curr != null) {

            if (curr.data == key) {
                floor = curr.data;
                break;
            }

            if (curr.data < key) {
                floor = curr.data;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        curr = root;

        // Find Ceil
        while (curr != null) {

            if (curr.data == key) {
                ceil = curr.data;
                break;
            }

            if (curr.data > key) {
                ceil = curr.data;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(floor);
        ans.add(ceil);

        return ans;
    }
}