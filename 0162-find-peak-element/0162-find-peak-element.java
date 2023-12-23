
class Solution {
    public int findPeakElement(int[] nums) {
         int max_val=nums[0], max_index = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]>max_val){
                max_index=i;
                max_val = nums[i];
            }
        }
        return max_index;
    }
}