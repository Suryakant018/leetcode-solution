class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0, j=0, product = 1, ans =0;

        while(j < nums.length){
            product *= nums[j];

            while(product >= k && i <= j){
                product /= nums[i];
                i++;
            }
            ans += (j-i+1);
            j++;
        }
        return ans;
    }
}