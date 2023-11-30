class Solution {
    public int hIndex(int[] citations) {
        int l = 1;
        int h = citations.length;
        while(l<=h){
            int m = l + (h-l)/2;
            if(possibleH(m,citations)){
                l = m + 1; //maxmizing the ans
            }else{
                h = m - 1; // as we found (number of papers) that is not having at least m citations ==> noOfPaoers>m => need to minimize my ans
            }
        }
        return h;
    }

    public boolean possibleH(int cite,int[] citations){
       int total = 0;
       for(int c:citations){
           if(c>=cite){
               total++;
           }
       } 
       return total>=cite;
    }
}
