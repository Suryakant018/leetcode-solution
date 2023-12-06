
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

   public void preorderTraversal (TreeNode root, StringBuilder pre) {
		if (root == null) {
			pre.append("null,");
			return;
		}

		pre.append(root.val);
		pre.append(",");

		preorderTraversal (root.left, pre);
		preorderTraversal (root.right, pre);
	}
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder pre = new StringBuilder();
		preorderTraversal (root, pre);
		return pre.toString();
    }
    int itr=0;
    public  TreeNode construct(String[] preArray) {
		if (itr >= preArray.length) {
			return null;
		}
		
		if (preArray[itr].equals("null")) {
			itr++;
			return null;
		}
		
		TreeNode root = new TreeNode(Integer.parseInt(preArray[itr]));
		itr++;
		root.left = construct(preArray);
		root.right = construct(preArray);

		return root;
	}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] preArray = data.split(",");
		return construct(preArray);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;