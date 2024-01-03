class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int result[] = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && deque.getLast()<nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        result[0] = deque.getFirst();
        for(int i=k;i<nums.length;i++){
            if(deque.getFirst()==nums[i-k]){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.getLast()<nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            result[i-k+1] = deque.getFirst();
        }
        return result;
    }
}