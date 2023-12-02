class Solution {
    public int countCharacters(String[] words, String chars) {
        int []arr = new int[26];
        for (int i = 0; i<chars.length(); i++){
            arr[chars.charAt(i)-'a']++;
        }
        int count = 0;
        for (String st : words){
            boolean flag = true;
            int idx = 0;
            for (int i = 0; i<st.length(); i++){
                char c = st.charAt(i);
                if (arr[c-'a']>0){
                    arr[c-'a']--;
                    idx++;
                } else {
                    break;
                }
            }
            if (idx == st.length()){
                count += idx;
            }
            for (int i = 0; i<idx; i++){
                arr[st.charAt(i)-'a']++;
            }
        }
        return count;
    }
}