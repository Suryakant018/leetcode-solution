class Solution {
    List<Integer>list=new ArrayList<>();
    Set<String>set=new HashSet<>();
    Queue<int[]>queue=new LinkedList<>();
    List<List<Integer>> nums;
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        this.nums=nums;
        int start[]=new int[2];
        set.add(0+","+0);
        queue.add(start);
        while(queue.size()!=0){
            int pair[]=queue.poll();
            int r=pair[0];int c=pair[1];
            list.add(nums.get(r).get(c));
            add(r+1,c);
            add(r,c+1);
        }
        int res[]=new int[list.size()];
        for(int i=0;i<list.size();i++)res[i]=list.get(i);
        return res;
    }
    public void add(int r,int c){
        if(r<0||r>=nums.size())return;
        List<Integer>col=nums.get(r);
        if(c<0||c>=col.size())return;
        String pos=r+","+c;
        if(set.contains(pos))return;
        set.add(pos);
        int next[]=new int[]{r,c};
        queue.add(next);
    }
}