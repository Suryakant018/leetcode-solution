class Solution {
    public String customSortString(String order, String s) {
        int freq[] = new int[26];
        for(char c: s.toCharArray()) {
            //Store frequency of chars
            freq[c - 'a']++;
        }
        StringBuilder str = new StringBuilder();
        for(char c: order.toCharArray()) {
            if(freq[c-'a'] > 0) {
                //add all chars based on the order string
                str.append(String.valueOf(c).repeat(freq[c-'a']));
                freq[c-'a'] = 0;
            }
        }
        for(char c = 'a';c<='z';c++) {
            if(freq[c-'a'] > 0) {
                // add remaining chars
                str.append(String.valueOf(c).repeat(freq[c-'a']));
            }
        }
        return str.toString();
    }
}