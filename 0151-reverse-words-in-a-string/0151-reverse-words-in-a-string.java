
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String newS = s.replaceAll("\\s{2,}"," ");
        String[] words = newS.split(" ");
        for(int i=words.length-1; i >= 0; i--) {
                sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}