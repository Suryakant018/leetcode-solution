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
    int ans=0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return ans;
    }
    void helper(TreeNode node){
        if(node==null){
            return;
        }
        if(node.left!=null && node.left.left==null && node.left.right==null){
            ans+=node.left.val;
            
        }
        helper(node.left);
        helper(node.right);
    }
}