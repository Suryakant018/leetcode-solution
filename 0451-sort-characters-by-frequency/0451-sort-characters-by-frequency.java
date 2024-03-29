class Solution {
    public String frequencySort(String s) {

        Map<Character, Integer> mp = new HashMap<>();
        for(char x : s.toCharArray()){
           mp.put(x, mp.getOrDefault(x,0)+1);
        }
        List<Map.Entry<Character, Integer>> lt = new ArrayList<>(mp.entrySet());
        Collections.sort(lt, new Comparator<Map.Entry<Character, Integer> >(){
            public int compare(Map.Entry<Character, Integer>a , Map.Entry<Character, Integer> b){
                return b.getValue()-a.getValue();
            }
        });
        StringBuffer b = new StringBuffer();
        for(Map.Entry<Character, Integer> e : lt){
            int i=0;
            while(e.getValue()>i){
                b.append(e.getKey());
                i++;
            }
        }
        return b.toString();
    }
}