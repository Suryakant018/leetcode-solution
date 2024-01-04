class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int count = 0, p1 = 0, p2 = 0;
        if (n == 0 && m >= 0) {
            return true;
        }
        if (m <= n) {
            return false;
        }
        while (p1 < n && p2 < m) {
            if (s.charAt(p1) == t.charAt(p2)) {
                count++;
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        return count == n;
    }
}