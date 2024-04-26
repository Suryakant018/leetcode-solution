class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int minPrevRow = Integer.MAX_VALUE;
                for (int prevCol = 0; prevCol < n; prevCol++) {
                    if (prevCol != col) {
                        minPrevRow = Math.min(minPrevRow, dp[row - 1][prevCol]);
                    }
                }
                dp[row][col] = grid[row][col] + minPrevRow;
            }
        }

        int minPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][i]);
        }

        return minPathSum;
    }
}

