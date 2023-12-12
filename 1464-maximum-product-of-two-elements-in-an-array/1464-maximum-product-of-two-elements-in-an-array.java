class Solution {
  public int maxProduct(int[] nums) {
    int maxiA = 0, maxiB = 0;

    for(int n : nums)
      if     (n >= maxiA) {maxiB = maxiA; maxiA = n;}
      else if(n >  maxiB)  maxiB = n;

    return (maxiA-1) * (maxiB-1);     
  }
}