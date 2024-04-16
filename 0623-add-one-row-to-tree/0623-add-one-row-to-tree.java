class Solution {
    private void assignNode(TreeNode root, int depth, int val) {
        if (depth == 1) {
            TreeNode old_left = root.left;
            TreeNode old_right = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = old_left;
            root.right.right = old_right;
            return;
        }
        else {
            if (root.left != null) {
                assignNode(root.left, depth - 1, val);
            }
            if (root.right != null) {
                assignNode(root.right, depth - 1, val);
            }
        }
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newroot = new TreeNode(val);
            newroot.left = root;
            return newroot;
        }
        assignNode(root, depth - 1, val);
        return root;
    }
}