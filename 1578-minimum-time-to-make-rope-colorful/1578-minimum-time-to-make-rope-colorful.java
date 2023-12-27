
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime=0;
        int n=colors.length();
        int i=0,j=1;
        while(i<j && i<n && j<n){
            if(colors.charAt(i)==colors.charAt(j)){
                if(neededTime[i]<=neededTime[j]){
                    minTime+=neededTime[i];
                    i=j;
                    j++;
                }
                else{
                    minTime+=neededTime[j];
                    j++;
                }
            }
            else{
                i=j;
                j++;
            }
        }
        return minTime;
    }
}