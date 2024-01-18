class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for(; n > 1; n--){
            int temp = b;
            b = a + b;
            a = temp;
        }
            
        return b;
    }
}
