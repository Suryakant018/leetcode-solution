class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
             if (curr == '(') cnt++;
             else if (curr == ')'){
                if (cnt > 0) cnt--;
                else set.add(i);
             }
        }
        for (int i = s.length() - 1; i >= 0 && cnt > 0; i--) {
            char curr = s.charAt(i);
            if (curr == '(') {
                cnt--;
                set.add(i);
            }
        }
        

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

}