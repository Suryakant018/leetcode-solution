class Solution {
    public int findSpecialInteger(int[] arr) {
        
        Map<Integer, Integer> counts = new HashMap<>();
        for(int e : arr) {
            counts.put(e, counts.getOrDefault(e, 0) + 1);
        }

        int percent = arr.length / 4;
        for(int ele : counts.keySet()) {
            if(counts.get(ele) > percent) {
                return ele;
            }
        }
        return -1;
    }
}