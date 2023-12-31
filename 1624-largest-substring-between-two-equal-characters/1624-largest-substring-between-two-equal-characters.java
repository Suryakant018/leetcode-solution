class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int firstArr[]=new int[26];
        Arrays.fill(firstArr, -1);
        int maxLen=-1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(firstArr[c-'a']==-1){
                firstArr[c-'a']=i;
            }
            else{
                maxLen=Math.max(maxLen,i-firstArr[c-'a']-1);
            }
        }
        return maxLen;
    }
}
