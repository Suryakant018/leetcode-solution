
 
class Solution {
   int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        checkSum(root);
        return ans;
    }
    int checkSum(TreeNode root){
        if(root==null)
        return 0;
        int l=checkSum(root.left);
        int r=checkSum(root.right);
        int k=Math.max(Math.max(l,r)+root.val,root.val);
        ans=Math.max(ans,Math.max(l+r+root.val,k));
        return k;
    }
}