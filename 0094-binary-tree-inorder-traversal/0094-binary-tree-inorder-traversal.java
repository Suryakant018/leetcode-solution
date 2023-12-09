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
 /*                     <---: RECURSIVE SOLUTION:--->
class Solution {
    List<Integer>l=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return l;
    }
    
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }
        traverse(root.left);
       this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        while(root != null) {
            if(root.left != null) {
                TreeNode pred = root.left;
                while(pred.right != null && pred.right != root) {
                    pred = pred.right;
                }

                if(pred.right == null) {
                    pred.right = root;
                    root = root.left;
                } else {
                    pred.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
            } else {
                ans.add(root.val);
                root = root.right;
            }
        }

        return ans;
    }
} 























 