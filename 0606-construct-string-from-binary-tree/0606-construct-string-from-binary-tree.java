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
  * }
 */
class Solution {

    public String preOrder(TreeNode root) {

        String ans = "";
        String left = "(";
        String right = "";

        int cur = root.val;

        if(root.left == null && root.right == null) {
            return ans += cur;
        }

        if(root.left != null) {
            left += preOrder(root.left);
        }
        left += ")";

        if(root.right != null) {
            right += "(" + preOrder(root.right) + ")";
        }

        ans += cur + left + right;

        return ans;
    }
    public String tree2str(TreeNode root) {
        
        return preOrder(root);
    }
}