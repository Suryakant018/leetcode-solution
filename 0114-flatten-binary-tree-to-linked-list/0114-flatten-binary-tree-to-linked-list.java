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
    List<Integer> temp =new ArrayList<>();

    public void flatten(TreeNode root) {
        TreeNode t1=root;
       if(root != null){
            helper(root);
            t1.left=null;
        for(int i=1;i<temp.size();i++){
            t1.right=new TreeNode(temp.get(i),null,null);
            t1=t1.right;
        }
      }
    }
    public void helper(TreeNode root){
        if(root == null) return ;


        temp.add(root.val);

        helper(root.left);

        helper(root.right);

    }
}