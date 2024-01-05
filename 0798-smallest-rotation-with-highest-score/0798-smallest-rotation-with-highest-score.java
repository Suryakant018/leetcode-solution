class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] loss = new int[n];
        for(int i = 0; i < n; i++){
            loss[(i - nums[i] + 1 + n) % n]--;
        }
        int res = 0;
        for(int i = 1; i < n; i++){
            loss[i] += loss[i - 1] + 1;
            res = loss[i] > loss[res] ? i : res;
        }
        return res;
    }
}