
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(0, new ArrayList<String>(), s, res);
        return res;
    }

    public void dfs(int startIndex, List<String> path, String s, List<String> res) {
        if (path.size() == 4 && startIndex == s.length()) {
            res.add(String.join(".", path));
            return;
        }

        for (int i=startIndex; i<startIndex+3; i++) {
            if (i<s.length()) {
                String str = s.substring(startIndex, i+1);
                if ((str.length() > 1 && str.charAt(0) == '0') || Integer.parseInt(str) > 255) {
                    continue;
                }
                path.add(str);
                dfs(startIndex+str.length(), path, s, res);
                path.remove(path.size()-1);
            }
        }
    }
}

    