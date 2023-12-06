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
class Solution 
{
    int totalPath = 0 ;
    public void helper(TreeNode root, long currSum, int targetSum)
    {
        if(root == null)
        {
            return;
        }
        currSum = currSum + root.val ;
        if(currSum == targetSum)
        {
            totalPath++;
        }
        helper(root.left, currSum, targetSum);
        helper(root.right, currSum, targetSum);
    }
    public void helper1(TreeNode root, int targetSum)
    {
        if(root == null)
        {
            return ;
        }
        helper(root, 0, targetSum);
        helper1(root.left, targetSum);
        helper1(root.right, targetSum);
    }
    public int pathSum(TreeNode root, int targetSum) 
    {
        helper1(root, targetSum);
        return totalPath;
    }
}