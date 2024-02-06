
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> map = new HashMap<>();
        for(String s: strs){
            int key = generateKey(s);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public int generateKey(String s){
        int[] alphabet = new int[26];
        for(char c: s.toCharArray()){
            alphabet[c - 'a']++;
        }
        return Arrays.hashCode(alphabet);
    }
}