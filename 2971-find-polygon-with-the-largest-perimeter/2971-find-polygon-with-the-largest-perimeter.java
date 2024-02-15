class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long ans = -1;
        long previousElement_prefix = 0;

        for(int n : nums){
            if(n < previousElement_prefix){
                ans = previousElement_prefix + n;
            }
            previousElement_prefix += n;
        }
        return ans;
    }
}