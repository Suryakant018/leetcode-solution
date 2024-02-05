class Solution {
    public int firstUniqChar(String s) {
        int freq[]=new int[256];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'0']++;
        }
        int res=-1;
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'0']==1){
                res=i;
                break;
            }
        }
      
        return res;
    }
}