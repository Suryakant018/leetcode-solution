class Solution {
    public String concatinate(String[] str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< str.length; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String str1 = concatinate(word1);
        String str2 = concatinate(word2);

        if(str1.equals(str2)){
            return true;
        }
        return false;
    }
}