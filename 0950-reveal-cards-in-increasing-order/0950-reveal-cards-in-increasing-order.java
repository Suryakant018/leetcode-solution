class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // we will store index in the queue 
        Queue<Integer>q=new LinkedList<Integer>();
        Arrays.sort(deck);
        int n=deck.length;
        int[] ans = new int[n];
        int j=0;
        // System.out.println(Arrays.toString(deck));
        for(int i=0;i<n;i++){
          q.add(i);  
        }

        while(!q.isEmpty()){
            int idx=q.remove();
            ans[idx]=deck[j++];
            if(!q.isEmpty()){
                int idx2=q.remove();
            q.add(idx2);
            }
            
        }
        return ans;
    }
}
