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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        recursion(root, new StringBuilder(), list);
        return list;
    }

    public void recursion(TreeNode root, StringBuilder sb, List<String> list) {
        if(root.left == null && root.right == null) {
            sb.append(root.val);
            list.add(sb.toString());
        }

        sb.append(root.val);
        sb.append("->");

        if(root.left != null){
            recursion(root.left, new StringBuilder(sb.toString()), list);
        }
        if(root.right != null){
            recursion(root.right, new StringBuilder(sb.toString()), list);
        }
    }
}