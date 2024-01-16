class Solution {
    public String addStrings(String num1, String num2) {
        int n1=num1.length();
        int n2=num2.length();
        int i=n1-1,j=n2-1;
        int carry=0;
        String s="";
        while(i>=0&&j>=0){
            int x=num1.charAt(i--)-'0';
            int y=num2.charAt(j--)-'0';
            s=((carry+x+y)%10)+s;
            carry=(carry+x+y)/10;
        }
        while(i>=0){
            int x=num1.charAt(i--)-'0';
            s=((carry+x)%10)+s;
            carry=(carry+x)/10;
        }
        while(j>=0){
            int y=num2.charAt(j--)-'0';
            s=((carry+y)%10)+s;
            carry=(carry+y)/10;
        }
        if(carry!=0){
            s=carry+s;
        }
        return s;
    }
}