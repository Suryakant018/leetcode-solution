class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        else{
            HashMap<Character,Character> h1=new HashMap<>();
            HashMap<Character,Character> h2=new HashMap<>();
            for(int i=0;i<s.length();i++){
                char ch1=s.charAt(i);
                char ch2=t.charAt(i);
                if(h1.containsKey(ch1)){
                    if(h1.get(ch1)!=ch2){
                        return false;
                    }
                }else{
                    if(h2.containsKey(ch2)){
                        return false;
                    }
                    h1.put(ch1,ch2);
                    h2.put(ch2,ch1);
                }
            }
        }
        return true;
    }
}
