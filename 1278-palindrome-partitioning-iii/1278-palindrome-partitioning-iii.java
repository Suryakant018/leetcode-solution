class Solution {

    int totalChange(ArrayList<Integer> al) {
        int start = 0;
        int end = al.size() - 1;

        int ans = 0;

        while (start < end) {
            if (al.get(start) != al.get(end)) {
                ans++;
            }
            start++;
            end--;
        }

        return ans;
    }

    int dp[][];
    boolean vis[][];

    int solve(char c[], int k, int cur) {
        int n = c.length;

        if (cur >= n) {
            if (k == 0) {
                return 0;
            }

            return (int) 1e3 + 5;
        }

        if (k == 0) {
            return (int) 1e3 + 5;
        }

        if (vis[cur][k]) {
            return dp[cur][k];
        }

        int ans = Integer.MAX_VALUE;

        ArrayList<Integer> al = new ArrayList<>();

        for (int i = cur; i <= (n - k); i++) {
            int curChar = c[i] - 'a';
            al.add(curChar);

            int totalChange = totalChange(al);

            ans = Math.min(ans, totalChange + solve(c, k - 1, i + 1));
        }

        vis[cur][k] = true;
        dp[cur][k] = ans;

        return ans;
    }

    public int palindromePartition(String str, int k) {
        char c[] = str.toCharArray();

        dp = new int[c.length + 1][c.length + 1];
        vis = new boolean[c.length + 1][c.length + 1];

        return solve(c, k, 0);
    }
}