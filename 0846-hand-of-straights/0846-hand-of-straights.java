class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        // Sort the hand to make it easier to form consecutive groups
        Arrays.sort(hand);
        ArrayList<Integer> r=new ArrayList<>();
        for (int h : hand) {
            r.add(h);
        }
        while(!r.isEmpty()){
            int first=r.get(0);
            for(int i=0;i<groupSize;i++){
                int target=first+i;
                // Check if target is in the list
                if(!r.contains(target)){
                    return false;
                }
                // Remove the target element
                r.remove(Integer.valueOf(target));
            }
        }
        return true;
    }
}
