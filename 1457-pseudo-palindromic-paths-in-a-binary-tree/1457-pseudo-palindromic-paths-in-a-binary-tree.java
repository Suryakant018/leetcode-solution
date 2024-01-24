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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] pseudoPalindroms = new int[1];
        int[] map = new int[10];
        getPseudoPalindromicPaths(root, pseudoPalindroms, map);
        return pseudoPalindroms[0];
    }
    
    public void getPseudoPalindromicPaths(TreeNode root, 
    int[] pseudoPalindroms, int[] map){
         if(root == null){
             return;
         }
         map[root.val]++;
         getPseudoPalindromicPaths(root.left, pseudoPalindroms, map);
         getPseudoPalindromicPaths(root.right, pseudoPalindroms, map);
         if(root.left == null && root.right == null){
             if(isPseudoPalindrom(map)){
                pseudoPalindroms[0]++;
            }
         }
         map[root.val]--;
     }

     public boolean isPseudoPalindrom(int[] map){
        int oddOccurenceElements = 0;
         for(int index = 0; index < map.length; index++){
            if(map[index] != 0 && map[index]%2 != 0){
                oddOccurenceElements++; 
            }
        }
        return oddOccurenceElements <= 1;
     }
}