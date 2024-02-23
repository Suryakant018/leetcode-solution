class tuple{
    int node;
    int cost;
    int stop;
    tuple(int a,int b,int c){
        node=a;
        cost=b;
        stop=c;
    }
}
class pair{
    int node;
    int cost;
    pair(int a,int b){
        node=a;
        cost=b;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }
        Queue<tuple>pq=new ArrayDeque<>();
        pq.add(new tuple(src,0,0));
        int[]dist=new int[n];
        Arrays.fill(dist,(int)(1e9));
        dist[src]=0;
        while(pq.size()>0){
            tuple temp=pq.poll();
            int currnode=temp.node;
            int currcost=temp.cost;
            int currstop=temp.stop;
            if(currstop>k)continue;
            for(pair it:adj.get(currnode)){
                int adjnode=it.node;
                int adjcost=it.cost;
                if(dist[adjnode]<adjcost+currcost)continue;
                pq.add(new tuple(adjnode,currcost+adjcost,currstop+1));
                dist[adjnode]=currcost+adjcost;
            }
        }
        if(dist[dst]==(int)(1e9))return -1;
        return dist[dst];   
    }
}