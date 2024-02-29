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
    private final TreeNode END_OF_LEVEL = new TreeNode(Integer.MIN_VALUE);
    public boolean isEvenOddTree(TreeNode root) {
        //put root in queue
        //traverse each level
        //if level is odd, check if nodes are decreasing and even
        //if leve is even, check if nodes are increasing and odd
        Queue<TreeNode> qu = new LinkedList<>();
        int currentLevel = 0;
        qu.add(root);
        qu.add(END_OF_LEVEL);
        TreeNode last = null;

        while(!qu.isEmpty()) {
            TreeNode curr = qu.poll();
            if (curr == null) continue;
            if (curr.val == END_OF_LEVEL.val) {
                if (qu.isEmpty()) break;
                last = null;
                currentLevel++;
                qu.add(END_OF_LEVEL);
            } else {
                if (curr.left != null) qu.add(curr.left);
                if (curr.right != null) qu.add(curr.right);
                if (currentLevel != 0) {
                    if (currentLevel % 2 == 0) {
                        if (curr.val % 2 == 0) {
                            return false;
                        } else if (last != null) {
                            if (curr.val <= last.val) return false;
                        }
                    } else {
                        if (curr.val % 2 != 0) {
                            return false;
                        } else if (last != null) {
                            if (curr.val >= last.val) return false;
                        }
                    }
                } else {
                    //root must be odd
                    if (curr.val % 2 == 0) return false;
                }
                last = curr;
            }
        }

        return true;

    }
}