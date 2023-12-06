
class Solution {
    public String toGoatLatin(String sentence) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        
        String[] s = sentence.split(" ");
        String start = "";
        String end ="" ;
        String ans="";

        for(int i=0;i<s.length;i++){
            end = end+"a";

            if(list.contains(s[i].charAt(0))){
                s[i]=s[i]+"ma"+end;
            }else{
                start = s[i].charAt(0)+"";
                s[i]=s[i].substring(1)+start+"ma"+end;
            }
            if(i==0){
                ans=ans+s[i];

            }else{
                ans=ans+" "+s[i];

            }
            

        }

        return ans;




    }
}