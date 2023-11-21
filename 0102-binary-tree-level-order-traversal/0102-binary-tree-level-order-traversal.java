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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        //res will hold all elements of all levels
        List<List<Integer>> res = new ArrayList<>();
        //The queue will hold all elements of an ith element
        Queue<TreeNode> queue = new LinkedList<>();
        //Add root to queue
        queue.add(root);
        //We keep going until queue is empty, which means we reached the last level
        while(!queue.isEmpty()){
            //Get current elements in this level from queue length
            int levelLength=queue.size();
            List<Integer> temp = new ArrayList<>();
            //We iterate and add only non null values to queue and temp
            for (int i = 0; i < levelLength; i++) {
                TreeNode current = queue.poll();
                if(current!=null){
                    if(current.left!=null){
                        queue.add(current.left);
                    }
                    if(current.right!=null){
                        queue.add(current.right);
                    }
                    temp.add(current.val);
                }
            }
            if(!temp.isEmpty()){
                res.add(temp);
            }
        }
        return res;
    }
}