class Solution {
    public String ring;
    public String key;
    public int max = (int)1e8;
    public int n;
    public Integer dp[][][];
    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;
        n = ring.length();
        dp = new Integer[n][key.length()][3];
        return getMinSteps(0, 0, 0);
    }
    public int getMinSteps(int ind, int keyIndex, int last){

        //base case
        if(keyIndex == key.length()) return 0;
        if(dp[ind][keyIndex][last] != null) return dp[ind][keyIndex][last];

        int result = max;

        char ch = ring.charAt(ind);
        char keyCh = key.charAt(keyIndex);

        int found = max;
        if(ch == keyCh){
            found = 1 + getMinSteps(ind, keyIndex+1, 0);
            result = Math.min(result, found);
        }else{
            int clockWise = max;
            if(ind == 0 && last != 2){
                clockWise = 1 + getMinSteps(n-1, keyIndex, 1);
            }else if(last != 2){
                clockWise = 1 + getMinSteps(ind-1, keyIndex, 1);
            }

            int antiClockWise = max;
            if(ind == n-1 && last != 1){
                antiClockWise = 1 + getMinSteps(0, keyIndex, 2);
            }else if(last != 1){
                antiClockWise = 1 + getMinSteps(ind+1, keyIndex, 2);
            }

            int rotationResult = Math.min(clockWise, antiClockWise);
            result = Math.min(result, rotationResult);
        }
        return dp[ind][keyIndex][last] = result;
    }
}