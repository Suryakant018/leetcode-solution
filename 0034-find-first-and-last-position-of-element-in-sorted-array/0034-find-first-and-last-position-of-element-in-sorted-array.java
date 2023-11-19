
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int[] ans = new int[2];
        int first = firstOcc(nums, target);
        int last = lastOcc(nums, target);
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
    public int firstOcc(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int length = nums.length;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                res = mid;
                right = mid - 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
    public int lastOcc(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int length = nums.length;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                res = mid;
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}