
import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> reverseMap = new HashMap<>();
        String[] arr = s.split(" ");

        if (arr.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = arr[i];
            
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(word)) {
                    return false;
                }
            } else {
                if (reverseMap.containsKey(word) && reverseMap.get(word) != ch) {
                    return false;
                }
                map.put(ch, word);
                reverseMap.put(word, ch);
            }
        }

        return true;
    }
}
