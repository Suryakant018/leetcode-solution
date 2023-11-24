class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[index++] = i + 1;
        }
        List<Integer> path = new ArrayList<>();
        helper(nums, 0, path, res, k);
        return res;
    }
    private void helper(int[] nums, int startIndex, List<Integer> path, List<List<Integer>> res, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, i + 1, path, res, k);
            path.remove(path.size() - 1);
        }
        
    }
}