
// Definition for a Node.


class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node cur = root;
        while (cur != null) {
            cur = connectNode(cur);
        }
        return root;
    }

    private Node connectNode(Node cur) {
        if (cur == null) {
            return null;
        }
        if (cur.left != null && cur.right != null) {
            cur.left.next = cur.right;
            cur.right.next = connectNode(cur.next);
            return cur.left;
        } else if (cur.left != null) {
            cur.left.next = connectNode(cur.next);
            return cur.left;
        } else if (cur.right != null) {
            cur.right.next = connectNode(cur.next);
            return cur.right;
        }
        return connectNode(cur.next);
    }
}