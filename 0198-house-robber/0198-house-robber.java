class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robUtil(nums, 0, dp);
    }

    public int robUtil(int[] nums, int i, int[] dp) {
        if(i >= nums.length) 
            return 0;
        if(dp[i] != -1) 
            return dp[i];
        int taken = nums[i] + robUtil(nums, i + 2, dp);
        int notTaken = robUtil(nums, i + 1, dp);
        return dp[i] = Integer.max(taken, notTaken);
    }
}