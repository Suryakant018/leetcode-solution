class Solution {
    int[][][] dp ;
    
//     r1 = {x,y} == {n,m}     
    public int solve(int[] r1 ,int[] r2 ,int[][] grid){
        int n = grid.length, m = grid[0].length;
        if( r1[0] == n-1 || r2[0] == n-1 ){
            return (grid[r1[0]][r1[1]] + grid[r2[0]][r2[1]]);
        }      
        int cr = r1[0] , c1 = r1[1] ,c2 = r2[1];
        if( dp[cr][c1][c2]  != -1 )
            return dp[cr][c1][c2];
            
        int[] dj = {-1,0,1};
        int ret = 0;
        ret = grid[r1[0]][r1[1]] + grid[r2[0]][r2[1]];
        int add = 0;
        for(int i = 0 ; i < 3 ; i++ ){
            int nr1 = r1[0] +1 , nc1 = r1[1]+dj[i];
            if( nc1 < 0 || nc1 >= m)
                continue;
            for(int j = 0; j < 3 ; j++ ){
                int nc2 = r2[1]+dj[j];
                if( nc2 < 0 || nc2 >= m || nc1 == nc2)
                    continue;
                int temp = solve(new int[]{nr1,nc1},new int[] {nr1,nc2},grid);
                add = Math.max(temp,add);
            }
        }
        dp[cr][c1][c2] = (ret+add);
        return ( ret + add );
    }
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new int[n+3][m+3][m+3];
        
        for(int[][] ar : dp )
            for(int[] a :ar)
            Arrays.fill(a,-1);
        
        return solve(new int[]{0,0}, new int[]{0,m-1},grid);
        
    }
}