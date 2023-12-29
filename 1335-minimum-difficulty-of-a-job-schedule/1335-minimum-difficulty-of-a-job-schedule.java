class Solution {
    public int minDifficulty(int[] jobDifficulty, int days) {
        int n = jobDifficulty.length;
        if (n < days) { // length of jobs should not less than days.
            return -1;
        }

        int[][] dp = new int[days][n];
        for(int[] temp : dp) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }

        dp[0][0] = jobDifficulty[0];

        for(int j=1; j<n; j++) {
            dp[0][j] = Math.max(dp[0][j-1], jobDifficulty[j]);
        }

        int tempSum = 0;
        for(int i=0; i<days; i++) {
            tempSum += jobDifficulty[i];
            dp[i][i] = tempSum;
        }

        // given i <= j,
        for(int i=1; i < days; i++) {
            for(int j=i+1; j < n; j++) {
                int maxDifficulty = jobDifficulty[j];
                dp[i][j] = dp[i-1][j-1] + maxDifficulty;
                for(int k=j-2; k >= i-1; k--) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[k+1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + maxDifficulty);
                }
            }
        }

        return dp[days-1][n-1];
    }
}