class Solution {
    int strangePrinterHelp(int l, int r, int dp[][], String s) {
        // if( l>r ) return 0;
        if( dp[l][r] != -1 ) return dp[l][r];

        int mini = Integer.MAX_VALUE, j = -1;
        for(int i=l; i<r; i++){
            if( s.charAt(i) != s.charAt(r) && j == -1 ) j = i;

            if( j != -1 ) 
                mini = Math.min(mini, 1 + strangePrinterHelp(j, i, dp, s) + strangePrinterHelp(i+1, r, dp, s));
        }
        return dp[l][r] = (mini == Integer.MAX_VALUE ? 0 : mini);
    }


    // TOP DOWN DP
    public int strangePrinter1(String s) {
        int n = s.length(), dp[][] = new int[n][n];
        for(int row[] : dp) Arrays.fill(row, -1);
        return strangePrinterHelp(0, n-1, dp, s) + 1;
    }


    // BOTTOM UP DP
    public int strangePrinter(String s) {
        int n = s.length(), dp[][] = new int[n][n];

        for(int l=n-1; l>=0; l--){
            for( int r=0; r<n; r++ ){
                int mini = Integer.MAX_VALUE, j = -1;
                for(int i=l; i<r; i++){
                    if( s.charAt(i) != s.charAt(r) && j == -1 ) j = i;

                    if( j != -1 ) 
                        mini = Math.min(mini, 1 + dp[j][i] + dp[i+1][r]);
                }
                dp[l][r] = mini == Integer.MAX_VALUE ? 0 : mini;
            }
        }
        return dp[0][n-1] + 1;
    }
}