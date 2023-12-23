
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        Map<Node, Node> map = new HashMap<>();
        copyNode(map, node);
        Set<Node> visited = new HashSet<>();
        copyNei(map, visited, node);
        return map.get(node);
    }
    private void copyNode(Map<Node, Node> map, Node node){
        if(map.containsKey(node)){
            return;
        }
        map.put(node, new Node(node.val, new ArrayList<>()));
        List<Node> neighbors = node.neighbors;
        for(Node nei : neighbors){
            copyNode(map, nei);
        }
    }
    private void copyNei(Map<Node, Node> map, Set<Node> visited, Node node){
        visited.add(node);
        Node newNode = map.get(node);
        List<Node> neighbors = node.neighbors;
        for(Node nei : neighbors){
            newNode.neighbors.add(map.get(nei));
            if(!visited.contains(nei)){
                copyNei(map, visited, nei);
            }
        }
    }
}