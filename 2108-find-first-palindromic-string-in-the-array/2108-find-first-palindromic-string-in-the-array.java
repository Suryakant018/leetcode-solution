class Solution {
    public String firstPalindrome(String[] words) {
                for(int i=0;i<words.length;i++){                //iterating through each word
            for(int f=0,l=words[i].length()-1;f<=l;f++,l--){//iterating through chars of current word
                if(words[i].charAt(f)!= words[i].charAt(l)) //not palindrome
                    break;
                if(f== l-1 || f==l)     //traversed all words satisfying the condition
                    return words[i];    //current word
            }
        }
        return "";      //no palindrome found
    }

    
}