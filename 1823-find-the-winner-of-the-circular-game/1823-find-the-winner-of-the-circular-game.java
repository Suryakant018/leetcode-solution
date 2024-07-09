import java.util.ArrayList;

class Solution {
   
    public int winner(int n , int k)
    {
        if(n == 1)
        {
            return 0;
        }
        int idx = winner(n-1 , k);
        idx = (idx + k) % n;
        return idx;
    }
    public int findTheWinner(int n, int k) {
       

     
        int result = winner(n,k);
        return result + 1;
        
    }

}