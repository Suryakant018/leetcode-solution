class KthLargest {
    int ind=0;
    List<Integer> l =new ArrayList<>();


    public KthLargest(int k, int[] nums) {
        ind=k;

        for(int e:nums)
         l.add(e);


    }
    
    public int add(int val) {
        l.add(val);
        Collections.sort(l);
        return l.get(l.size()-ind);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */