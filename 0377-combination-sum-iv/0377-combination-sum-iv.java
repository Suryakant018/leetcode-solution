

class Solution {
    int [] nums;
    int [] dp;
    int empty = Integer.MIN_VALUE;
    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        dp = new int[(nums.length * 200) +2];
        Arrays.fill(dp, empty);
        return ways(target);
    }

    public int ways(int sum){
        if (sum==0) return 1;
        if (sum<0) return 0;
        
        if(dp[sum] == empty){
            int total_ways = 0;
            for (int i = 0; i < nums.length; i++) {
                total_ways += ways(sum - nums[i]);
            }
            dp[sum] = total_ways;
        }

        return dp[sum];
    }
}