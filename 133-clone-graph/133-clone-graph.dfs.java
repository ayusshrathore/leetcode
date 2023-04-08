/*
// Definition for a Node.
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
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Map<Node, Node> mp = new HashMap<>(); // {originalNode -> cloneNode}
        
        Node cloneNode = new Node(node.val); // clone the given node
        mp.put(node, cloneNode);
        
        dfs(node, cloneNode, mp); // clone above node's neighbours & recursively their neighbours
        
        return cloneNode;
    }
    public void dfs(Node node, Node currCloneNode, Map<Node, Node> mp) {
        for(Node n : node.neighbors) {
            if(mp.get(n) == null) { // if clone of the original node doesn't exists
                Node cloneNode = new Node(n.val);
                mp.put(n, cloneNode);
                
                currCloneNode.neighbors.add(cloneNode);
                
                dfs(n, cloneNode, mp);
            } else {
                currCloneNode.neighbors.add(mp.get(n)); // if a node reappears add it's corresponding cloneNode
            }
        }
    }
}
