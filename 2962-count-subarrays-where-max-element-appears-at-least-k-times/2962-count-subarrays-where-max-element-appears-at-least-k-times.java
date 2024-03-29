class Solution {
    public long countSubarrays(int[] nums, int k) {
        long maxNumber=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxNumber)maxNumber=nums[i];
        }
        long maxCount=0;
        int l=0;
        long result=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==maxNumber){
                maxCount++;
            }
            while(maxCount==k){
                if(nums[l]==maxNumber){
                    maxCount--;
                }
                l++;
            }
            result+=l;
        }
        return result;
    }
}