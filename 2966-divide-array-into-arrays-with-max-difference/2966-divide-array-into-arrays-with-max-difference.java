class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if(n%3 != 0 ) return new int[][]{};
        Arrays.sort(nums);
        int size = n/3;
        int ans[][] = new int[size][3];
        int j = 0;
        for(int i =0;i<n;i+=3){
            if(nums[i+2] - nums[i] <= k){
                ans[j][0] = nums[i];
                ans[j][1] = nums[i+1];
                ans[j][2] = nums[i+2];
            }else {
                return new int[][]{};
            }
            j++;
        }
        return ans;
    }
}