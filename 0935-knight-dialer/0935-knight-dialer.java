class Solution {
    int MOD = 1000000007;
    Map<Integer, List<Integer>> numberCanRecieveMove;
    
    public int knightDialer(int n) {
        // Map used to check a number can be reached from which number
        // i.e. for 0, you can reach from 4 and 6.
        // i.e. for 1, you can reach from 6 and 8,.....
        numberCanRecieveMove = new HashMap<>();
        numberCanRecieveMove.put(0, Arrays.asList(4,6));
        numberCanRecieveMove.put(1, Arrays.asList(6,8));
        numberCanRecieveMove.put(2, Arrays.asList(7,9));
        numberCanRecieveMove.put(3, Arrays.asList(4,8));
        numberCanRecieveMove.put(4, Arrays.asList(0,3,9));
        numberCanRecieveMove.put(5, Arrays.asList());
        numberCanRecieveMove.put(6, Arrays.asList(0,1,7));
        numberCanRecieveMove.put(7, Arrays.asList(2,6));
        numberCanRecieveMove.put(8, Arrays.asList(1,3));
        numberCanRecieveMove.put(9, Arrays.asList(2,4));

        int ans = 0;
        int[][] dp = new int[n][10];
        for(int i=0;i<10;i++) {
            dp[0][i] = 1;
        }
        for(int i=1;i<n;i++) {
            for(int j=0;j<10;j++) {
                for(int prevNum: numberCanRecieveMove.get(j)) {
                    dp[i][j]= (dp[i][j] + dp[i-1][prevNum])%MOD;
                }
            }
        }
        for(int i=0;i<10;i++) {
            ans = (ans + dp[n-1][i]) % MOD;
        }
        return ans;
    }
}