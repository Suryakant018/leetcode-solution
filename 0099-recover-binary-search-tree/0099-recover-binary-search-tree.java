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
    List<List<Integer>> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        recursion(root);
        updateNodes(root, list.get(list.size() - 1).get(0), list.get(list.size() - 1).get(1));
    }

    public void updateNodes(TreeNode root, int first, int second){
        if(root == null) return;
        if(root.val == first) root.val = second;
        else if(root.val == second) root.val = first;
        updateNodes(root.left, first, second);
        updateNodes(root.right, first, second);
    }

    public TreeSet<Integer> recursion(TreeNode root){
        TreeSet<Integer> set = new TreeSet<>();
        if(root == null) return set;
        TreeSet<Integer> left = recursion(root.left);
        TreeSet<Integer> right = recursion(root.right);
        if(left.size() > 0 && right.size() > 0 && left.last() > right.first() && left.last() > root.val && right.first() < root.val){
            List<Integer> temp = new ArrayList<>();
            temp.add(left.last());
            temp.add(right.first());
            list.add(temp);
        }else{
            if(left.size() > 0 && left.last() > root.val){
                List<Integer> temp = new ArrayList<>();
                temp.add(left.last());
                temp.add(root.val);
                list.add(temp);
            }
            if(right.size() > 0 && right.first() < root.val){
                List<Integer> temp = new ArrayList<>();
                temp.add(right.first());
                temp.add(root.val);
                list.add(temp);
            }
        }
        TreeSet<Integer> op = new TreeSet<>();
        op.addAll(left);
        op.add(root.val);
        op.addAll(right);
        return op;
    }
}