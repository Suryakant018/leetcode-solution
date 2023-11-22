
class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while(n>0) {
            int c = n%26;
            n = n/26;
            if(c==0) { res.append('Z'); n -= 1; }
            else res.append((char)(64+c));
        }
        res = res.reverse();
        return res.toString();
    }
}