class Solution {
      public int maxWidthOfVerticalArea(int[][] points) {

        int[] xPts = new int[points.length];
        for (int i = 0; i < points.length; i++) {
                xPts[i] = points[i][0];
        }
        Arrays.sort(xPts);
        int ans=0;
        for (int i = 0; i < xPts.length-1; i++) {
            ans= Math.max(ans, xPts[i+1] - xPts[i]);
        }
        return ans;
    }
}