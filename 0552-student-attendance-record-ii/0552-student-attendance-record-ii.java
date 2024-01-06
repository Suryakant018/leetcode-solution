class Solution {
    public int checkRecord(int n) {
        if (n == 0) return 1;
        if (n == 1) return 3;
        if (n == 2) return 8;
		
        int mod = 1000000007;

        int lateOnly1 = 1;
        int lateOnly2 = 2;
        int lateOnly3 = 4;

        int lateAndAbsent1 = 1;
        int lateAndAbsent2 = 3;
        int lateAndAbsent3 = 8;

        for (int i = 3; i <= n; i++) {
            int newLateAndAbsent = (((((lateOnly3 + lateAndAbsent3) % mod + lateOnly2) % mod + lateAndAbsent2) % mod + lateOnly1) % mod + lateAndAbsent1) % mod;
            lateAndAbsent1 = lateAndAbsent2;
            lateAndAbsent2 = lateAndAbsent3;
            lateAndAbsent3 = newLateAndAbsent;

            int newLateOnly = ((lateOnly3 + lateOnly2) % mod + lateOnly1) % mod;
            lateOnly1 = lateOnly2;
            lateOnly2 = lateOnly3;
            lateOnly3 = newLateOnly;
        }

        return lateAndAbsent3;
    }
}
