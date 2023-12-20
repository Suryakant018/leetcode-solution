class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //list to be returned
        List<List<Integer>> lastList = new ArrayList<>();
        //empty tree
        if (root==null){
            return lastList;
        }
        //queues to use
        Queue<TreeNode> myQueue = new LinkedList<>();
        Queue<TreeNode> alternate = new LinkedList<>();
        myQueue.add(root);
        List<Integer> integerList;
        while(!myQueue.isEmpty()){
            //creating and adding inner lists
            integerList = new ArrayList<>();
            while(!myQueue.isEmpty()){
                TreeNode node = myQueue.remove();
                //adding to inner list
                integerList.add(node.val);
                //adding the next level to secondary queue
                if (node.left!=null){
                    alternate.add(node.left);
                }
                if (node.right!=null){
                    alternate.add(node.right);
                }
            }
            //adding the inner list
            lastList.add(integerList);
            //returning the nodes back to main queue
            while (!alternate.isEmpty()){
                myQueue.add(alternate.remove());
            }
        }
        Collections.reverse(lastList);
        return lastList;
    }
}
