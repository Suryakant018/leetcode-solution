class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        if(citations[n-1] == 0) {
            return 0;
        }
        int res = 0;
        for(int i = n-1; i >= 0; i--) {
            if(citations[i] > res) {
                res++;
            }
        }

        return res;
    }
}