class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i=0; i<nums.length; i++) {
            int c = 1;
            while(i+1<nums.length && nums[i]==nums[i+1]) {
                c++;
                i++;
            }
            if(c==1) {
                nums[j] = nums[i];
                j++;
            } else {
                nums[j] = nums[i];
                nums[j+1] = nums[i];
                j = j+2;
            }
        }
        return j;
    }
}