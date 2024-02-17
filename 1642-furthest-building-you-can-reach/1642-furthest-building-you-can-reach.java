class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
       int n=heights.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1;i<n;i++){
            if(heights[i]>heights[i-1]){
               int  diff=heights[i]-heights[i-1];
                if(diff<=0){
                    continue;
                }
                else{
                    pq.add(diff);
                    if(pq.size()>ladders){
                        bricks-=pq.remove();
                    }
                    if(bricks<0){
                        return i-1;
                    }
                }
            }
        }
        return heights.length-1;
    }
}