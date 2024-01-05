class Solution {
    public int findMin(int[] nums) {
         int start=0; int end=nums.length-1;
         int mid; 

         while(start<end){
             mid=start+(end-start)/2; 

             //when ans at mid
             if(mid>start && nums[mid]<nums[mid-1])
                return nums[mid]; 

            else if(nums[mid]==nums[start]&& nums[mid]==nums[end]){
                end=end-1;
                start=start+1;
            }
             
            // when first half is sorted 
            else if(nums[start]<=nums[mid]){
                if(nums[start] >=nums[end]){
                    start=mid+1;
                }
                else
                {
                    return nums[start]; 
                }
            }

            // when first half is not sorted
            else if(nums[start]>nums[mid]){
                end=mid-1; 
            }
         }
         return nums[start]; 
    }
}