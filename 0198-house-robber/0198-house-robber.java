class Solution {
    public int paisa(int[] nums,int i,int[] map){
        if(i==0)return nums[i];
        if(i<0)return 0;
        if(map[i]!=-1)return map[i];
        int pick=nums[i]+paisa(nums,i-2,map);
        int na=0+paisa(nums,i-1,map);
        return map[i]= Math.max(pick,na);
    }
    public int rob(int[] nums) {
        int[] map=new int[nums.length];
        Arrays.fill(map,-1);
        return paisa(nums,nums.length-1,map);
    }
}