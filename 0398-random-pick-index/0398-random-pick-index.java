class Solution {
    Map<Integer,List<Integer>> map;
    Random random = new Random();
    public Solution(int[] nums) {
        map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> ids = map.get(target);
        return ids.get(random.nextInt(ids.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */