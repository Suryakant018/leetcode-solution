
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] a) {
        int n = a.length;
        int ans[] = new int[2];
        int res[] = new int[(n * n) + 1];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = a[i][j];
                if (res[x] == 1)
                    ans[0] = x;
                else {
                    res[x] = 1;
                    sum += x;
                }
            }
        }

        n = n * n;
        int total = (n * (n + 1)) / 2;
        ans[1] = total - sum;

        return ans;
    }

}