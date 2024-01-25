class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1,text2,0,0,new HashMap<>());
    }
    public int longestCommonSubsequence(String text1, String text2,int i,int j,HashMap<String,Integer> memo) {
        if(i>=text1.length()||j>=text2.length()){
            return 0;
        }
        String key=i+","+j;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int res=0;
        if(text1.charAt(i)==text2.charAt(j)){
            res=Math.max(1+longestCommonSubsequence(text1,text2,i+1,j+1,memo),res);
        }
        else{
         res=Math.max(longestCommonSubsequence(text1,text2,i+1,j,memo),
         longestCommonSubsequence(text1,text2,i,j+1,memo));
        }
    
        memo.put(key,res);
        return res;
        
        
    }
}