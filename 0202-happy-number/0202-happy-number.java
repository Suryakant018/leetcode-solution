class Solution {
    public boolean isHappy(int n) {
      int sum =0;
      int nf=n;
      int count =0;
        while(sum!=1){
          while(nf!=0){
          int rem = nf%10;
          sum +=  rem*rem; 
          nf = nf/10;
        } 
        count+=1;
        nf = sum;
        if(sum==1){
          return true;
        }
        if(sum>1&&sum<=9 && sum!=7){
          return false;
        }
        sum =0;
    }
    return false;
}
}