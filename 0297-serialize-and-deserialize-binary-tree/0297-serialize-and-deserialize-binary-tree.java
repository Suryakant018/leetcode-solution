/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode currNode = q.remove();
            if (currNode == null) {
                ans.append("#,");
            } else {
                ans.append(currNode.val).append(",");
            }

            if (currNode != null) {
                q.add(currNode.left);
                q.add(currNode.right);
            }
        }

        return ans.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data.isEmpty() || data.charAt(0) == '#') {
            return null;
        }
        String[] chars = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(chars[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 0;
        while (!q.isEmpty()) {
            TreeNode curr = q.remove();

            index++;
            if (index < data.length() && !Objects.equals(chars[index], "#")) {
                TreeNode left = new TreeNode(Integer.parseInt(chars[index]));
                curr.left = left;
                q.add(left);
            }

            index++;
            if (index < data.length() && !Objects.equals(chars[index], "#")) {
                TreeNode right = new TreeNode(Integer.parseInt(chars[index]));
                curr.right = right;
                q.add(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));