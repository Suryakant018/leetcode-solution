
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[26];
        List<Integer> res = new ArrayList<>();
        int m = p.length();
        int n = s.length();

        if(m > n){
           return res;
        }

        for(char c: p.toCharArray()){
            freq[c -'a']++;
        }

        int windowStart = 0;
        for(int windowEnd=0; windowEnd<n; windowEnd++){
            freq[s.charAt(windowEnd) -'a']--;

            if(windowEnd-windowStart+1 == m){
                if(isEqualFreq(freq)){
                    res.add(windowStart);
                }
                freq[s.charAt(windowStart) -'a']++;
                windowStart++;
            }
        }

        return res;
    }

    public boolean isEqualFreq(int[] freq){
        for(int num : freq){
            if(num != 0){
                return false;
            }
        }

        return true;
    }
}

//TC: O(N) + O(m*26)
//SC: O(26) ~= O(1)
