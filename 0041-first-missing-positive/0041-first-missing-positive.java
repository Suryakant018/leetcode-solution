class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] t = new int[nums.length+2];
        for(int num:nums) {
            if(num>0 && num<=nums.length) {
                t[num]=-1;
            }
        }
        for(int i=1;i<t.length;i++) {
            if(t[i]==0) {
                return i;
            }
        }
        return t.length+1;
    }
}