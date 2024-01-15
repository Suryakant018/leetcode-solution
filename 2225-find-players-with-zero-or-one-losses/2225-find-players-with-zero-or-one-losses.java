class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int size = 0;
        int[] win = new int[100001];
        int[] lose = new int[100001];

        for (int[] m : matches){
            int w = m[0];
            int l = m[1];
            size = Math.max(Math.max(w,l), size);
            win[w] = 1;
            lose[l]--;
        }

        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();

        for (int i = 0; i<=size; i++) {
            if (win[i] == 1 && lose[i] == 0) a.add(i);
            else if (lose[i] == -1) b.add(i);
        }
        
        return Arrays.asList(a,b);
    }
}