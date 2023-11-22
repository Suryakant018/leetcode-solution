class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        traverse(root, values);
        return values;
    }

    private void traverse(TreeNode root, List<Integer> values){
        if (root == null){
            return;
        }

        traverse(root.left, values);
        traverse(root.right, values);

        values.add(root.val);
    }
}