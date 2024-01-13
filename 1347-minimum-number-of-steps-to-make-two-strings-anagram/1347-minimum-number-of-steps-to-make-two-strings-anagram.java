class Solution {
    public int minSteps(String s, String t) {

        // frequency count of s
        int str[]=new int[26];

        // frequency count of t
        int tr[]=new int[26];


        for(char c:s.toCharArray()) str[c-'a']++;
        for(char c:t.toCharArray()) tr[c-'a']++;

        int ans=0;

        
        for(int i=0;i<26;i++){

            // means if s has more frequency then we need to replace it
            if(str[i]>tr[i]) ans+=(str[i]-tr[i]);
        }

        return ans;
        
    }
}