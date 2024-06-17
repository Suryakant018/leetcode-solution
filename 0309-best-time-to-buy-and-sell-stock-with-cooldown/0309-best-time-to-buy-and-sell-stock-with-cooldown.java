class Solution {
    public int maxProfit(int[] prices) {
    
        int[] dp = new int[prices.length + 2];
  
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < prices.length; j++)
                dp[i] = Math.max(dp[i], prices[j] - prices[i] + dp[j + 2]); 
            
            dp[i] = Math.max(dp[i], dp[i + 1]);

        }


        return dp[0];
    }
}