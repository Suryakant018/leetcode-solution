class Solution {
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return ans;
    }

    String ans = "";

    void dfs(TreeNode root, String curr) {
        if (root == null)
            return;
        int ch = root.val + 'a';
        char k = (char) ch;
        curr = k + curr;
        if ((root.left == null && root.right == null) && 
            (ans.equals("") || curr.compareTo(ans) < 0)) {
            ans = curr;
        }
        dfs(root.left, curr);
        dfs(root.right, curr);
    }
}