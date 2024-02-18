class Solution {
    class pair{
        int index;
        int finish;
        public pair(int index ,int finish){
            this.index = index;
            this.finish = finish;
        }
    }
    public int mostBooked(int rooms, int[][] meetings) {
       Arrays.sort(meetings,(a,b)->a[0]-b[0]);
    //    System.out.println(Arrays.deepToString(meetings));
       int n = meetings.length;
       int [] ans = new int[rooms];
    //    int r = 0;
       PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.finish== b.finish ? a.index-b.index : a.finish-b.finish);
       PriorityQueue<Integer> bcha_room = new PriorityQueue<>();
       for(int i = 0 ; i < rooms ; i++){
           bcha_room.offer(i);
       }
       for (int i = 0 ; i < n ; i++){
           int ms = meetings[i][0];
           int me = meetings[i][1];
         if(pq.isEmpty() && (!bcha_room.isEmpty())){
            //  System.out.print(bcha_room + " ");
            // System.out.print("yes");
            int r  = bcha_room.poll();
             pq.add(new pair (r,meetings[i][1]));
            ans[r]++;
            // System.out.println(Arrays.toString(ans));
         }
         else{
             
            if(ms >= pq.peek().finish){
                
                while(!pq.isEmpty() && ms >= pq.peek().finish){
               pair temp =  pq.poll();
                bcha_room.offer(temp.index);
                }
                //   System.out.print(bcha_room + " ");
                //   System.out.print("no1");
                int r  = bcha_room.poll();
                pq.offer(new pair(r,me));
                ans[r]++;
                // System.out.println(Arrays.toString(ans));
            }
            else{
                if(!bcha_room.isEmpty()){
                    //  System.out.print(bcha_room + " ");
                    //   System.out.print("no2");
                    int r = bcha_room.poll();
                    pq.offer(new pair(r,me));
                    ans[r]++;
                    // System.out.println(Arrays.toString(ans));
                }
                else{
                    //  System.out.print(bcha_room + " ");
                    //   System.out.print("no3");
                    pair temp = pq.poll();
                    ans[temp.index]++;
                     
                    pq.offer(new pair(temp.index,me-ms+temp.finish));
                    // System.out.println(Arrays.toString(ans));
                }
            }
         }
       }
    //    System.out.println(Arrays.toString(ans));
         int max   = 0 ;
         int ind = -1 ;
         for(int i = 0 ; i < rooms ; i++){
             if(max < ans[i]){
                 max = ans[i];
                 ind = i;
             }
         }
         return ind;
    }
}