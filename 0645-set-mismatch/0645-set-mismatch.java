class Solution {
    public int[] findErrorNums(int[] nums) {
        int rep = -1, miss = -1;
        int[] freq = new int[nums.length+1];
        for(int n : nums){
            freq[n]++;
            if(freq[n] == 2) rep = n;
        } 
        for(int i=1; i<freq.length; i++){
            if(freq[i] == 0){
                miss = i;
                break;
            }
        }
        return new int[]{rep, miss};
    }
}