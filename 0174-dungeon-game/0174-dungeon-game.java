class Solution {
    int find(int[][] grid, int i, int j, int[][] dp) {
        if(i >= grid.length || j >= grid[0].length) return Integer.MIN_VALUE;
        if(i == grid.length-1 && j == grid[0].length-1) return grid[i][j] >= 0 ? 0 : grid[i][j];  
        if(dp[i][j] != -1) return dp[i][j];

        int curr = Math.max(find(grid,i+1,j,dp), find(grid,i,j+1,dp));
        if(curr+grid[i][j] >= 0) curr = 0;
        else if(curr >= 0) curr = grid[i][j];
        else curr += grid[i][j];

        return dp[i][j] = curr;
    }

    public int calculateMinimumHP(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return -1*(find(grid,0,0,dp)) + 1;
    }
}