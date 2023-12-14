
class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> sb1 = new Stack<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch>='0' && ch<='9'){
                num = num*10 + ch - '0';
            }else if(ch == '['){
                sb1.push(sb);
                sb = new StringBuilder();
                nums.push(num);
                num = 0;
            }else if(ch == ']'){
                StringBuilder temp = sb;
                sb = sb1.pop();
                int count = nums.pop();

                while(count-->0){
                    sb.append(temp);
                }
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}