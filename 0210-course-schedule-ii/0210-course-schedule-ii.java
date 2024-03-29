class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int indegree[] = new int[numCourses];
        calcIndgree(graph, indegree);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int answer[] = new int[numCourses];
        int index=0;
        while (!q.isEmpty()) {
            int curr = q.remove();
            answer[index++]=curr;

            for (int i = 0; i < graph[curr].size(); i++) {
                int e = graph[curr].get(i);
                indegree[e]--;

                if (indegree[e] == 0) {
                    q.add(e);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] > 0) {
                return new int[0]; // If cycle exists, return empty array
            }
        }

        return answer;

    }

    static void calcIndgree(ArrayList<Integer> graph[], int indegree[]) {
        for (int i = 0; i < indegree.length; i++) {
            int vertex = i;
            for (int j = 0; j < graph[vertex].size(); j++) {
                int e = graph[vertex].get(j);
                indegree[e]++;
            }
        }
    }

}