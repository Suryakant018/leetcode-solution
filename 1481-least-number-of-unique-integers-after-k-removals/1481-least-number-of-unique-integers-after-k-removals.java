class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap();      //to store frequency
        int n=arr.length;
        int[] f=new int[n+1];                        //to store count of numbers at each frequency, suppose [5,5,3,3], ie 2 elements of frequency 2
        int uni=0;                                   //total unique elements

        for(int num:arr){
            int c=map.getOrDefault(num,0);
            if(c==0){
                uni++;                               //if freq is 0 before means unique, increment
            }
            f[c]--;                                 // decrement earlier frequency count 
            f[c+1]++;                               //increment new frequency count 
            map.put(num,c+1);                       //incremenet frequency of that element 
        }
        //Using greedy approach lower frequencies, would be removed first as it will reduce the unique numbers by most
        for(int i=1;i<n+1;i++){
            //if there are lements at frequency i
            if(f[i]>0){
                while(f[i]>0 && k>=i){
                    k-=i;                           // reduce k by i frequency
                    f[i]--;                         //reduce 1 elemnt at frequency i
                    uni--;                          //decr uni by 1
                }
            }
            //if there are still elements at frequency i left means k is over to use and just return uni
            if(f[i]>0){
                return uni;
            }
            
        }
        return uni;
    }
}