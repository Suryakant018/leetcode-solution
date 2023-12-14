
class Solution {
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        // convert array to list
        List<Integer> temp = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toList());
        
        // use collections to handle shuffle
        Collections.shuffle(temp);
        
        // convert list back into array
        return temp.stream()
            .mapToInt(i->i)
            .toArray();
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */