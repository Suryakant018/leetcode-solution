
class Solution {
    public int maxScore(String s) {
    
        int result=0;
        int left=0,right=0;
        int total_one=0;
        for(int i=0;i<s.length();i++)
        if(s.charAt(i)=='1')total_one++;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='0')left++;
            else right++;
            int t=total_one-right;
            result=Math.max(result,t+left);
        }
        return result;
    }
}
