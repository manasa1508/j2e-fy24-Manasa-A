/*
3. Implement a function to clone a directed graph, where each node contains a label and a list of its neighbors.
Example:
Input:
graph = [[1,2],[2,3],[3,4],[4,5],[5,1]]
Output:
[[1,2],[2,3],[3,4],[4,5],[5,1]]*/
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
class prob_3{
    public void dfs(Node node,HashMap<Node,Node> dict){
        for (Node nd : node.neighbors) {
            if (!dict.containsKey(nd))
                dict.put(nd, new Node(nd.val));
            dict.get(node).neighbors.add(dict.get(nd));
        }
        for (Node nd : node.neighbors){
            if (dict.get(nd).neighbors.size() == 0)
                dfs(nd, dict);
        }
    }
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> dict = new HashMap<>();
        if (node != null) {
            dict.put(node, new Node(node.val));
            dfs(node, dict);
            return dict.get(node);
        }
        return null;
    }
}