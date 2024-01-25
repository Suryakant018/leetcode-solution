class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int openCount = 0, minRemovalReq = 0;
        for(char ch: s.toCharArray()){  //find the minimum parentheses to remove
            if(ch == ')'){
                if(openCount > 0)   openCount--;
                else                minRemovalReq++;
            }   
            else if(ch == '(')      openCount++;
        }
        minRemovalReq += openCount;
        Set<String> res = new HashSet<>();
        get_ans(s, 0, minRemovalReq, 0, "", res); //find all possible s by removing minimum parentheses and check if valid
        return new ArrayList<>(res);
    }
    private void get_ans(String s, int i, int n, int openCnt, String curr, Set<String> res){
        if(n == s.length() - i){    //left out chars are suppose to be removed since we need to remove exactly n parentheses
            if(openCnt == 0)    res.add(curr);  //checking validity
            return;
        }
        char ch = s.charAt(i);
        if(ch == '(' || ch == ')'){
            if(n > 0)    get_ans(s, i + 1, n - 1, openCnt, curr, res); //delete the char if possible
            openCnt += (ch == '('? 1 : -1);
            if(openCnt > -1)    get_ans(s, i + 1, n, openCnt, curr + ch, res);  //check validity to accept the current char
        }
        else{ //put all the letter which are not parentheses as it is
            StringBuilder sb = new StringBuilder(ch+"");
            while(++i < s.length() - n){
                ch = s.charAt(i);
                if(ch == '(' || ch == ')')  break;
                sb.append(ch);
            }
            get_ans(s, i, n, openCnt, curr + sb.toString(), res);
        }
    }
}
