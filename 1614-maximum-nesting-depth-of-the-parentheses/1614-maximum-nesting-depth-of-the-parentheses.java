class Solution {
    public int maxDepth(String s) {

        Stack<Character> st = new Stack();
        int max = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push('(');
            } else if(s.charAt(i) == ')' && (!st.isEmpty()) && st.peek() == '(') {
                st.pop();
            }
              max = Math.max(max, st.size());
        }

        return max;
        
    }
}