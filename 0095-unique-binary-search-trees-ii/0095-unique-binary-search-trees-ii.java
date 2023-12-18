


class Solution {
    public List<TreeNode> generateTrees(int n) {
        return constructTree(1, n);
    }

    private List<TreeNode> constructTree(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        for(int i = start;i<=end;i++){
            List<TreeNode> leftTree = constructTree(start, i - 1);
            List<TreeNode> rightTree = constructTree(i + 1, end);
            for(int j = 0;j<leftTree.size();j++){
                for(int k = 0;k<rightTree.size();k++){
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree.get(j);
                    node.right = rightTree.get(k);
                    list.add(node);
                }
            }
        }
        return list;
    }
}