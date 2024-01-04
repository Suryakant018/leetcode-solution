class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() < 1) return false;

        int state = 0;
        for(char c: s.toCharArray()){
            if( (c == '+' || c == '-') && state < 1){
                state = 1;
            }
            else if(Character.isDigit(c) && state < 3){
                state = 2;
            }
            else if(c == '.' && state < 3){
                state = (state == 2) ? 5 : 3;
            }
            else if(Character.isDigit(c) && state < 6){
                state = 5;
            }
            else if( (c == 'E' || c == 'e') && (state == 2 || state == 5)){
                state = 11;
            }
            else if( (c == '+' || c == '-') && state == 11){
                state = 12;
            }
            else if(Character.isDigit(c) && state > 10){
                state = 13;
            }
            else if(c == ' ') continue;
            else {
                state = -1;
                break;
            }
        }
        return state == 2 || state == 5 || state == 13;
    }
}