class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 1;
        Map<String, List<String>> graph = new HashMap<>();
        if (wordList.contains(endWord) == false) return 0;
        for (String word : wordList)
            graph.put(word, new ArrayList<>());
        for (String word : wordList)
            helper(wordList, word, graph);

        Deque<String> q = new ArrayDeque<>();

        char[] arrayW = beginWord.toCharArray();

        for (int i = 0; i < arrayW.length; i++) {
            char ori = arrayW[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ori)
                    continue;
                arrayW[i] = c;
                String temp = String.valueOf(arrayW);
                // System.out.println(temp);
                if (graph.containsKey(temp)) q.addLast(temp);
            }
            arrayW[i] = ori;

        }
        // System.out.println(q.size());
        // count++;
        Set<String> visited = new HashSet<>();
        while (q.isEmpty() == false) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                String word = q.removeFirst();
                visited.add(word);
                if (word.equals(endWord)) return count;
                for (String node : graph.get(word)) {
                    if (graph.containsKey(node) && visited.contains(node) == false) q.addLast(node);
                }
            }
            
        } 
        // System.out.println(graph.getOrDefault(endWord, new ArrayList<>()));
        // List<String> result = new ArrayList<>();

        return 0; // result.size();
    }

    private void helper(List<String> wordList, String word, Map<String, List<String>> graph) {

        char[] arrayW = word.toCharArray();

        for (int i = 0; i < arrayW.length; i++) {
            char ori = arrayW[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ori)
                    continue;
                arrayW[i] = c;
                String temp = String.valueOf(arrayW);
                if (graph.containsKey(temp))
                    graph.get(word).add(temp);
            }
            arrayW[i] = ori;
        }
    }
}