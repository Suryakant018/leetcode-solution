class Solution {
    public int totalMoney(int n) {
        int res=0;
        int start=1;
        int count=0;
        for(int i=1;i<=n;i++){
            if(count==7){
                start+=1;
                count=0;
            }
            res+=start+count;
            count++;
        }
        return res;
    }
}