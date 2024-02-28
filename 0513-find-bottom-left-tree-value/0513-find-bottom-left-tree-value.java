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
    int maxVal;
    int maxLevel;
    public int findBottomLeftValue(TreeNode root) {
        f(root,1);//if we take f(root,0) it wont work on some testcases having only root node 
        return maxVal;
    }
    private void f(TreeNode node,int lvl){
        if(node==null)return;
        if(node.left==null&&node.right==null){
            if(lvl>maxLevel){
                maxLevel=lvl;
                maxVal=node.val;
            }
            return;
        }
        f(node.left,lvl+1);
        f(node.right,lvl+1);
    }
}