class Solution {
    public boolean isAnagram(String s, String t) {
        s = sortedString(s);
        t = sortedString(t);
        return t.equals(s);
    }

    private String sortedString(String s){
        char[] sCharArr = s.toCharArray();
        Arrays.sort(sCharArr);
        return new String(sCharArr);
    }
}
