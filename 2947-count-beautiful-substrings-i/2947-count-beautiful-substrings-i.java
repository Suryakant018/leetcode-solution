class Solution {
     int vowel = 0;
     int consonant = 0;
     public int beautifulSubstrings(String s, int k) {
         int res = 0;
         if(s.length() == 1){
             res = 0;
         }
         for(int i = 0; i < s.length();){
             countVowel(s.charAt(i));
             for(int j = i + 1; j < s.length();){
                 countVowel(s.charAt(j));
                 if(vowel == consonant && (vowel * consonant) % k == 0){
                     res++;
                     j++;
                 }
                 else{
                     j++;
                 }
             }
             vowel = 0;
             consonant = 0;
             i++;
         }
         
         return res;
        
    }
    
    public void countVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            vowel++;
        }
        else{
            consonant++;
        }   
    }
}