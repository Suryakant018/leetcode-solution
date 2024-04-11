class Solution {
    public int mergeStones(int[] stones, int k) {
        if (stones.length == 1) return 0;
        int [] presum = new int[stones.length + 1]; // exclusive presum[i] = stones[0] +.. + stones[i-1]
        for (int i = 1; i <= stones.length ; i++) presum[i] = presum[i-1] + stones[i-1];
        return mergeStones(stones, k , 0, stones.length, new HashMap<>(),presum);
    }
    // startegy - devide the range into k sub ranges of size (k + (k-1) * r) which have been marged each before the last round into a single stone, combined with single stones that have been left for the last round and those singles stones act as a wall (can't merge with them before last round), similar to brust baloons problem but here we have to pick k groups before we start merging
    public int mergeStones(int[] stones, int k , int start, int end, HashMap<Integer , Integer> mamo, int [] presum ){
        int score = 0, min = 10000 , steps = 0 , key = ((end+1) << 15) +  start;
        if (mamo.containsKey(key)) return mamo.get(key);

        List<Stack<Integer>> lastMergesParmutations = getValidParmutations(start,end,k,0);// devide range start - end into k groups which merged before the last round (false) and singles who left for last(true)  
        for (Stack<Integer> lastMerge : lastMergesParmutations){
            score =  presum[end] - presum[start]; // whether the stone is a part of the last merge or it been merge before - add it to final score           
            steps = start;
            while (!lastMerge.isEmpty()){
                int nextSize = lastMerge.pop();
                if (nextSize != 1) score += mergeStones(stones, k , steps, steps + nextSize , mamo, presum) ; // merged before last round scores + we already taken the stones themself as we merged the sum again which contains all the stones
                steps += nextSize;
                
            }
            min = Math.min (min, score);
        }
        int ret = min < 10000 ? min : -1;
        mamo.put(key, ret);
        return ret;
    }

    private List<Stack<Integer>>  getValidParmutations(int start, int end, int k, int picked){ // we have to devide range start - end into k groups where each group is eigher size 1 (in the last merge) or size (k + (k-1) * r) for r >= 0 (as they can be merge into one stone)- so we can do backtracking (bit manipulation seems good but complicating)
        if (start > end || picked > k || (start == end && picked < k)) return null;
        List<Stack<Integer>> sol = new ArrayList<Stack<Integer>>();
        if (start == end && picked == k) {
            sol.add (new Stack<Integer>());
            return sol;
        }

        // with last item - 
        List<Stack<Integer>> withLast =  getValidParmutations(start, end -1 , k , picked + 1);
        if (withLast != null){
            for (Stack<Integer> s : withLast) s.push(1);
            sol.addAll(withLast);
        }

        // without last - go (k + (k-1) * r) steps for r>=0 , this is the middle that we merge before last move into 1 stone.
        for (int r = 0 ; start <=  end - (k + (k-1) * r) ; r++){
            int midSize = k + (k-1) * r;
            List<Stack<Integer>> withoutLast =  getValidParmutations(start,  end - midSize , k , picked + 1);
            if (withoutLast != null){
                for (Stack<Integer> s : withoutLast) s.push(midSize);
                sol.addAll(withoutLast);
            }
        }
        
        return sol;
    }   
}