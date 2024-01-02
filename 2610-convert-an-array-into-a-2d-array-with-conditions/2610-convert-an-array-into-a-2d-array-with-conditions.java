class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i],0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(!freqMap.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<Integer> keysToBeRemoved = new ArrayList<>();
            for(Integer i : freqMap.keySet()) {
                list.add(i);
                freqMap.put(i, freqMap.get(i) - 1);
                if(freqMap.get(i)==0) keysToBeRemoved.add(i);
            }
            for(int i : keysToBeRemoved) {
                freqMap.remove(i);
            }
            ans.add(list);
        }
        return ans;
    }
}