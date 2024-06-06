
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // create the graph
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] res = new double[queries.size()];

        for(int i=0;i < equations.size(); i++) {
            String pointA = equations.get(i).get(0);
            String pointB = equations.get(i).get(1);

            map.putIfAbsent(pointA, new HashMap<>());
            map.putIfAbsent(pointB, new HashMap<>());

            map.get(pointA).put(pointB, values[i]);
            map.get(pointB).put(pointA, 1.0 / values[i]);
        }

        int i = 0;
        for(List<String> query: queries) {
            String pointC = query.get(0);
            String pointD = query.get(1);
            if(!map.containsKey(pointC) || !map.containsKey(pointD)) {
                res[i] = -1.0;
                i++;
                continue;
            }

            Set<String> visited = new HashSet<>();
            Double result = dfs(pointC, pointD, map,visited);
            res[i] = result;
            i++;
        }

        return res;
    }

    public Double dfs(String current, String target, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if(current.equals(target)) return 1.0;
        visited.add(current);

        Map<String,Double> edge = graph.get(current);
        for(Map.Entry<String,Double> entry: edge.entrySet()) {
            if(visited.contains(entry.getKey())) continue;

            Double result = dfs(entry.getKey(), target, graph, visited);
            if(result!=-1.0) {
                return result * entry.getValue();
            }
        }

        return -1.0;
    }
}