class Solution {
    public int findJudge(int n, int[][] trust){
        Set<Integer> set = new HashSet<>();
        int judge = -1;
        int sum = 0;
        for(int i = 0; i < trust.length; i++){
            if(set.add(trust[i][0]))
              sum += trust[i][0];
        }
        int total = n*(n+1)/2;
        judge = total - sum;

        int cnt = 0;
        for(int i = 0; i < trust.length; i++){
            if(trust[i][1] == judge)
              cnt++;
        }
        return cnt >= n-1 ? judge : -1;
    }
}