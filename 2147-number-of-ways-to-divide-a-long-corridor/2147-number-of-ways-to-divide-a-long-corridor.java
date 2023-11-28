
class Solution {
    static int mod = 1000000007;
    public int numberOfWays(String s) {
        int n = s.length();
        int i = 0;
        long ans = 1;
        while(i < n) {
            int sCt = 0;
            while(i < n && sCt != 2) {
                if(s.charAt(i) == 'S')
                    sCt++;
                i++;
            }
            if(sCt != 2)    // no of S if just 1 after a partition, we can never divide it to requirement
                return 0;

            int plantCt = 0;
            while(i < n && s.charAt(i) == 'P') {
                plantCt++;
                i++;
            }
            if(i < n)   // as I want to ignore plant count after last segragation of 'S' pair
                        // ie. ignore SSPP -> last 2 P count must be ignored
            {
                ans *= (plantCt + 1);
                ans %= mod; 
            }   
        }
        return (int)(ans % 1000000007);
    }
}