class Solution {
    private final int SIDES = 4;

    public boolean makesquare(int[] matchsticks) {

        int sum = arr_sum(matchsticks);
        if (sum % SIDES != 0)
            return false;

        Arrays.sort(matchsticks);

        if (backtrack(new int[SIDES], sum / SIDES, new int[] { matchsticks.length - 1 }, matchsticks))
            return true;

        return false;
    }

    public boolean backtrack(int[] subsets, int target, int[] matchstick_idx, int[] matchsticks) {

        // base case
        if (matchstick_idx[0] < 0) {
            if (isPossible(target, subsets))
                return true;

            return false;
        }

        // general case
        for (int i = 0; i < subsets.length; i++) {

            if (subsets[i] + matchsticks[matchstick_idx[0]] > target)
                continue;

            subsets[i] += matchsticks[matchstick_idx[0]];
            matchstick_idx[0]--;

            if (backtrack(subsets, target, matchstick_idx, matchsticks))
                return true;

            matchstick_idx[0]++;
            subsets[i] -= matchsticks[matchstick_idx[0]];
           
           if(subsets[i] == 0) break;
        
        }

        return false;
    }

    public boolean isPossible(int target, int[] subsets) {
        for (int sum : subsets)
            if (sum != target)
                return false;

        return true;
    }

    public int arr_sum(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks)
            sum += matchstick;
        return sum;
    }
}