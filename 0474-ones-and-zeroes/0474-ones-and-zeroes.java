
class Solution {
    int m;
    int n ;
    int[][][] ans;
    public int findMaxForm(String[] strs, int m, int n) {
        int n1= strs.length;
        this.m =m;
        this.n = n;
        ans = new int[n1+1][m+1][n+1];
        for(int[][] a:ans)
            for(int[] b:a)
                Arrays.fill(b,-1);
        return rec(n1,strs,m,n);
    }
    int rec(int n, String[] strs,  int i , int j)
    {
        if(ans[n][i][j] != -1)
            return ans[n][i][j];
        if(n==0)
        {
            ans[n][i][j] =  0;
            return ans[n][i][j];
        }
        if(i==0 && j==0){
            ans[n][i][j] =  0;
            return ans[n][i][j];
        }
        

        int[] count =countZerosAndOnes(strs[n-1]);

        if(count[0]<=i && j>=count[1])
        {
            ans[n][i][j] =  Math.max(rec(n-1,strs,i,j),rec(n-1,strs,i-count[0], j-count[1])+1);
        }
        else
            ans[n][i][j] = rec(n-1,strs,i,j);

        return ans[n][i][j];
    }
    int[] countZerosAndOnes(String s)
    {
        int[] ans = new int[2];
        for(char c : s.toCharArray())
            if(c=='0') ans[0]++;
            else ans[1]++;
        return ans;
    }
}