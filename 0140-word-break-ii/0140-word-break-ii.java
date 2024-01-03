class Solution {
    private class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word = null;

        boolean hasChar(char c){
            return next[c-'a']!=null;
        }

        TrieNode getNext(char c){
            return next[c-'a'];
        }

        boolean hasWord(){
            return word !=null;
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode trieTree = createTree(wordDict);
        List<String> curWords = new ArrayList<>();
        List<String> curSentences = new ArrayList<>();
        dfs(s, 0, trieTree, trieTree,curSentences, curWords);
        return curSentences;
    }

    private void dfs(String s, int index, TrieNode trieTree, TrieNode curNode,List<String> curSentences,
                     List<String> curWords){
        if(index==s.length()){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < curWords.size();i++){
                stringBuilder.append(curWords.get(i));
                if(i<curWords.size()-1){
                    stringBuilder.append(' ');
                }
            }
            curSentences.add(stringBuilder.toString());
            return;
        }

        char curChar = s.charAt(index);

        if(curNode.hasChar(curChar)){
            TrieNode next = curNode.getNext(curChar);
            if(next.hasWord()){
                curWords.add(next.word);
                dfs(s, index+1, trieTree, trieTree, curSentences, curWords);
                curWords.remove(curWords.size()-1);
            }
            if(index+1<s.length()) {
                dfs(s, index + 1, trieTree, next, curSentences, curWords);
            }
        }
    }

    private TrieNode createTree(List<String> wordDict){
        TrieNode trieNode = new TrieNode();
        for(String s: wordDict){
            TrieNode cur = trieNode;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(cur.next[c-'a'] == null){
                    cur.next[c-'a'] = new TrieNode();
                }
                cur = cur.next[c-'a'];
            }
            cur.word = s;
        }
        return trieNode;
    }
}