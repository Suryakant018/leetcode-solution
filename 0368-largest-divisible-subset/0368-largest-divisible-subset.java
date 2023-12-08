class Solution {
    public List<Integer> largestDivisibleSubset(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int[] hash = new int[n];
		int max = 1, lastIndex = 0;
		for(int i=0;i<n;i++) {
			hash[i] = i;
			for(int j=0;j<i;j++) {
				if(A[i]%A[j] == 0 && dp[i]<1+dp[j]) {
					dp[i] = 1 + dp[j];
					hash[i] = j;
				}
			}
			if(dp[i]>max){
				max = dp[i];
				lastIndex = i;
			}
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(A[lastIndex]);
		while(hash[lastIndex] != lastIndex) {
			lastIndex = hash[lastIndex];
			al.add(A[lastIndex]);
		}
        return al;
    }
}