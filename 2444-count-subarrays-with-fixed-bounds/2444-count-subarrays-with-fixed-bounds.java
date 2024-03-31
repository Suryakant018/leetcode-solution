class Solution {
    // Method to count subarrays within specified range [minK, maxK]
    public long countSubarrays(int[] nums, int minK, int maxK) {
        // Variable to store the count of valid subarrays
        long res = 0;
        // Variables to keep track of indices
        int badIdx = -1, leftIdx = -1, rightIdx = -1;

        // Loop through the array
        for (int i = 0; i < nums.length; ++i) {
            // Check if the current element is outside the range [minK, maxK]
            if (!(minK <= nums[i] && nums[i] <= maxK)) {
                // If it is, mark this index as the "bad" index
                badIdx = i;
            }

            // Check if the current element is equal to minK
            if (nums[i] == minK) {
                // If it is, update the left index to the current index
                leftIdx = i;
            }

            // Check if the current element is equal to maxK
            if (nums[i] == maxK) {
                // If it is, update the right index to the current index
                rightIdx = i;
            }

            // Calculate the number of valid subarrays at each step
            // by taking the minimum of leftIdx and rightIdx and subtracting the badIdx
            res += Math.max(0, Math.min(leftIdx, rightIdx) - badIdx);
        }

        // Return the count of valid subarrays
        return res;
    }
}
