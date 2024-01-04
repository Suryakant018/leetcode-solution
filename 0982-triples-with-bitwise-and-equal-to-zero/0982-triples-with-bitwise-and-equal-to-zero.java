class Solution {
    public int countTriplets(int[] nums) {
        
        
        int count[][] = new int[3][(1<<16)+1];

        for(int i = 0; i < nums.length; i++ ) {
            count[0][nums[i]]++;
        }

        for(int i = 1; i < 3; i++) {
            for(int j = 0; j < count[i].length; j++) {
                if ( count[i-1][j] > 0 ) {
                    for(int a = 0; a < nums.length; a++) {
                        count[i][(j&nums[a])] += count[i-1][j];
                    }
                }
            }
        }

        return count[2][0];
    }
}
