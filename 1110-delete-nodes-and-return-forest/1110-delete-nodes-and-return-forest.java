class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> l = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        delete(root, set, l, true);
        return l;
    }

    private TreeNode delete(TreeNode root, Set<Integer> set, List<TreeNode> l, boolean isroot) {
        if (root == null) {
            return null;
        }
        if (isroot && !set.contains(root.val)) {
            l.add(root);
        }
        root.left = delete(root.left, set, l, set.contains(root.val));
        root.right = delete(root.right, set, l, set.contains(root.val));
        return set.contains(root.val) ? null : root;
    }
}