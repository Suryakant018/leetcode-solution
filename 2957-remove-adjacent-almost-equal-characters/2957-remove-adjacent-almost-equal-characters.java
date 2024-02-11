class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int count=0,i=0;
        if(word.length()==1){return 0;}
        while(i<word.length()-1){
            int m = Math.abs(word.charAt(i) - word.charAt(i+1));
            if(m==1 || m==0){
                count++;
                i+=2;
            }
            else{
                i++;
            }
        }
        return count;
    }
}