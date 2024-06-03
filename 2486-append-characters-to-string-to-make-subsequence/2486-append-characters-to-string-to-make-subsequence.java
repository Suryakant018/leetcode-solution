class Solution {
    public int appendCharacters(String s, String t) {
        
        int slen = s.length();
        int tlen = t.length();

        int tIdx = 0;
        int sIdx = 0;

        while(sIdx < slen){
            if(tIdx == tlen){
                break;
            }
            if(s.charAt(sIdx) == t.charAt(tIdx)){
                tIdx++;
            }
            sIdx++;
        }

        return tlen-tIdx;
    }
}