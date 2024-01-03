class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int count=0;
        int n=batteryPercentages.length;
        for(int i=0;i<n;i++){
            if(batteryPercentages[i]>0){
               batteryPercentages=TestedDevices(batteryPercentages,i,n);
               count++;
            }
        }
        return count;
    }

    public int[] TestedDevices(int[] batteryPercentages,int j,int n){
        int[] arr=new int[n];
        for(int i=0;i<=j;i++){
            arr[i]=batteryPercentages[i];
        }
        for(int i=j+1;i<n;i++){
            if(batteryPercentages[i]-1!=0){
              arr[i]=batteryPercentages[i]-1;
            }
            
        } 
        return arr;
    }
}