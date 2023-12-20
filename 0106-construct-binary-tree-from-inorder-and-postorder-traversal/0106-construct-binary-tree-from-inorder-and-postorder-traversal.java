
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0||inorder.length==0) return null;

        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        int rootPosition = findIndex(inorder, rootVal);

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootPosition), Arrays.copyOfRange(postorder, 0, rootPosition));
        root.right = buildTree(Arrays.copyOfRange(inorder, rootPosition+1, inorder.length), Arrays.copyOfRange(postorder, rootPosition, postorder.length-1));
        return root;
    }

    int findIndex (int[] arr, int target){
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == target) return i;
        }
        return -1;
    }
}
