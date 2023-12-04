class Solution {
    public int[] findRightInterval(int[][] intervals) {
        // array to store the start indices of each interval
        int[] startIndices = new int[intervals.length];
        int[] result = new int[intervals.length];
        // mp to store the index of each interval based on start indices(as it's unique)
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i = 0; i < intervals.length; i++) {
            startIndices[i] = intervals[i][0];
            mp.put(intervals[i][0],i);
        }

        // sort the start indices so that we can use binary search
        // to find a start index that is greater than equal to end index of examing interval
        Arrays.sort(startIndices);

        int i = 0;
        for(int[] interval : intervals) {
            int target = interval[1];
            int ind = bsGtEq(startIndices,target);
            // if the target is not present
            if(ind == -1)
                result[i++] = -1;
            // if target is found, get the index from map
            else {
                result[i++] = mp.get(startIndices[ind]);
            }
        }
        return result;
    }

    // bs to find index having value greater than and equal to target
    private int bsGtEq(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right) {
            int mid = left + (right-left)/2;

            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (right == nums.length)?-1:right;
    }
}