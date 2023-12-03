class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int length = points.length,ans=0;
        for(int i=1;i<length;i++)
        {
            ans+=Math.max(Math.abs(points[i][0]-points[i-1][0]),Math.abs(points[i][1]-points[i-1][1]));
        }  
        return ans;
    }
}