
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     public boolean isValidBST(TreeNode root){
        if (root == null) {
            return true;
        }
        return isValidBSTUtil(root, new Integer[]{null});
    }
    public boolean isValidBSTUtil(TreeNode root, Integer[] previous) {
        if (root == null) {
            return true;
        }

        if(!isValidBSTUtil(root.left, previous)) {
            return false;
        }

        // previous is null if it's the first node
        if(previous[0] != null && previous[0] >= root.val) {
            return false;
        }
        previous[0] = root.val;

        if(!isValidBSTUtil(root.right, previous)) {
            return false;
        }

        return true;
    }
}