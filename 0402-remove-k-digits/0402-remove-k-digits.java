class Solution {
    public String removeKdigits(String num, int k) {
        var s = new Stack<Character>();
        for(var i : num.toCharArray()){
            while(!s.isEmpty() && s.peek() > i && k > 0){
                s.pop();
                k--;
            }
            s.push(i);
        }
        while(k > 0 && !s.isEmpty()){
            s.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        for(var i : s){
            ans.append(i);
        }
        //deleting leading zeroes
        while (!ans.isEmpty() && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        return !ans.toString().isEmpty() ? ans.toString() : "0";
    }
}