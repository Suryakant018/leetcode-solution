class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int number = 0 ;
        int result = 0 ;
        int sign = 1 ;

        for ( int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
               number = (number * 10 )  + (int) (c - '0');
            }
            else if (c == '+'){
               result += (number * sign);
               number = 0 ;
               sign = 1;
            }
            else if ( c == '-'){
               result += (number * sign);
               number = 0 ;
               sign = -1;
            }
            else if ( c == '('){
               stack.push(result);
               stack.push(sign);
               number = 0 ;
               result = 0 ;
               sign = 1 ;
            }
             else if ( c== ')'){
              result += (number * sign);
              number = 0;

              result *= stack.pop(); // cal sign 
              result += stack.pop(); //cal result 
             }
        }
        if(number!=0)  result += (number * sign);
        return result ;
    }
}