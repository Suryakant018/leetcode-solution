class Solution {
    public boolean halvesAreAlike(String s) {
        int vowels=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(i<n/2){
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
                vowels++;
            }
            }
            else{
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
                vowels--;
            }
            }
        }
        if(vowels==0) return true;
        return false;
    }
}