class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[]=new int[nums.length];
        int left_product=1;
        for(int i=0;i<ans.length;i++){
            ans[i]=left_product;
            left_product*=nums[i];
        }
        int right_product=1;
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=ans[i]*right_product;
            right_product*=nums[i];
        }
        return ans;
    }
}