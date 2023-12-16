class Solution {
    public int longestSubstring(String s, int k) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Step 1: Initialize an array to count the frequency of each character (assuming lowercase English alphabet characters)
        int[] charCount = new int[26];

        // Step 2: Count the frequency of characters in the string
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Step 3: Check if the string is valid (all characters have a frequency >= k)
        boolean valid = true;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0 && charCount[i] < k) {
                valid = false;
                break;
            }
        }

        // Step 4: If the string is valid, return its length
        if (valid) {
            return s.length();
        }

        // Step 5: Split the string and find the maximum length among valid substrings
        int start = 0; // Starting index for splitting the string
        int maxLen = 0; // Maximum length of valid substrings

        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] < k) {
                // Split the string and recursively check the substring
                maxLen = Math.max(maxLen, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }

        // Check the remaining substring
        maxLen = Math.max(maxLen, longestSubstring(s.substring(start), k));

        // Step 6: Return the maximum length among valid substrings
        return maxLen;
    }
}