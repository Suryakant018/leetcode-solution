class Solution {
    public boolean judgeSquareSum(int c) {
        long s = 0;
        long e = (long)Math.sqrt(c);
        while (s <= e) {
            long n = (long)(Math.pow(s, 2) + Math.pow(e, 2));
            if (n == c) {
                return true;
            } else if (n < c) {
                s++;
            } else {
                e--;
            }
        }
        return false;
    }
}