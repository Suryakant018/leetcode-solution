class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] n =  new boolean[nums.length];
        for( int i : nums){
            if(n[i]) return i;
            n[i] = true;
        }
        return 0;
    }
}