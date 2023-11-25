class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int right = 0;
        int left = 0;
        int[] result = new int[nums.length];
        int n = nums.length;
        for(int i = 0 ; i < n ; i++) right +=nums[i];
        for(int i = 0 ; i < n ; i++){
            right -= nums[i];
            result[i] = right - left - (n - 2*i - 1)*nums[i];
            left += nums[i];
        }
        return result;
    }
}