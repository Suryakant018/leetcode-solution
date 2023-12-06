class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        final Map<Integer, Integer> seen = new HashMap<>();
        for(int a: nums1)
            for(int b: nums2)
                seen.put(a+b, seen.getOrDefault(a+b, 0) + 1);
        for(int a: nums3)
            for(int b: nums4)
                count += seen.getOrDefault(-(a+b), 0);        
        return count;
    }
}