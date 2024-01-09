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
class Solution {
    public ArrayList<Integer> leafs(TreeNode root, ArrayList<Integer> ans){
       
        if(root==null){ //base case.
            return null;
        }

        if(root.left==null && root.right==null){
            ans.add(root.val);
        }

        leafs(root.left,ans);
        leafs(root.right,ans);

        return ans;

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
                ArrayList<Integer> ans1=new ArrayList<>();
                ArrayList<Integer> ans2=new ArrayList<>();

                ans1=leafs(root1,ans1);
                ans2=leafs(root2,ans2);

                return ans1.equals(ans2);

                //optimisation.



    
    }
}