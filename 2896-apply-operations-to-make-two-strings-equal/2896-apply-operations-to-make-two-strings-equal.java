class Solution {
    public int minOperations(String s1, String s2, int x) {
        int i=0, ans =0, pre = 1000000,temp,co=0;
        for(char c:s1.toCharArray()){
            char ch = s2.charAt(i++);
            pre +=2;
            if(c != ch) {
                co++;
                temp = ans;
                ans = ans+x < pre?ans+x:pre;
                pre = temp;
            }
        }
        return co%2 != 0?-1:ans/2;
    }
}