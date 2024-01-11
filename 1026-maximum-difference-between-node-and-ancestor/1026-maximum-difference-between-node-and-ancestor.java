/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        findMaxAncestorDiff(root.left, root.val, root.val);
        findMaxAncestorDiff(root.right, root.val, root.val);
        return res;

    }

    public void findMaxAncestorDiff(TreeNode root, int max_sofar, int min_sofar) {
        if (root == null) {
            return;
        }
        res = Math.max(res, Math.max((int) Math.abs(max_sofar - root.val), (int) Math.abs(min_sofar - root.val)));
        max_sofar = Math.max(max_sofar, root.val);
        min_sofar = Math.min(min_sofar, root.val);
        findMaxAncestorDiff(root.left, max_sofar, min_sofar);
        findMaxAncestorDiff(root.right, max_sofar, min_sofar);
       

    }
}