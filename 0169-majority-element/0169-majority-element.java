class Solution {
    public int majorityElement(int[] nums) {
        int median = nums.length / 2;
        int ans = 0;

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        for (int key : frequency.keySet()) {
            if (frequency.get(key) > median) {
                ans = key;
            }
        }

        return ans;
    }
}