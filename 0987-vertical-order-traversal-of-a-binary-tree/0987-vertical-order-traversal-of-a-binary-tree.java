
class Solution {

    Map<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

// t.c O(N*long(N))
//s.c O(N)
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        verticalTraversal(root, 0, 0);
        
        List<List<Integer>> ans = new ArrayList<>();
    
        for(TreeMap<Integer, List<Integer>> treeMap : map.values()) {
            List<Integer> newList = new ArrayList<>();
            // System.out.println("sf---1"+treeMap);
            for(List<Integer> list : treeMap.values()) {
                Collections.sort(list);

                // System.out.println("sf---"+list);
                newList.addAll(list);
            }
            ans.add(newList);
        }
        
        return ans;
    }
    
    void verticalTraversal(TreeNode root, int hd, int row) {
        
        if(root == null) return;
        
        TreeMap treeMap = map.get(hd);
        List<Integer> list;
        if(treeMap != null) {

            list = map.get(hd).get(row);

            if(list != null)
               list.add(root.val);
               else {
                list = new ArrayList<>();
                list.add(root.val);
                treeMap.put(row, list);
               }
        } else {
                 list = new ArrayList<>();
                 list.add(root.val);
                 treeMap = new TreeMap<>();

                 TreeMap<Integer, List<Integer>> newMap = new TreeMap<>();
                 newMap.put(row, list);
                 map.put(hd, newMap);
             
        }
        
        verticalTraversal(root.left, hd - 1, row + 1);
        verticalTraversal(root.right, hd + 1, row + 1);
    }
}