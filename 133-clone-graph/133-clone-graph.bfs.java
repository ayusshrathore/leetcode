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

class Solution { // BFS
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Map<Node, Node> mp = new HashMap<>(); // {originalNode -> cloneNode}
        
        Node currCloneNode = new Node(node.val); // clone the given node
        mp.put(node, currCloneNode);
        
        Queue<Node> q = new ArrayDeque<>(); // clone above node's neighbours & recursively their neighbours
        q.add(node);
        
        while(!q.isEmpty()) {
            Node currNode = q.remove();
            
            for(Node n : currNode.neighbors) {
                if(mp.get(n) == null) { // if clone of the original node doesn't exists
                    Node cloneNode = new Node(n.val);
                    mp.put(n, cloneNode);
                    mp.get(currNode).neighbors.add(cloneNode);
                    q.add(n);
                } 
                
                else 
                    mp.get(currNode).neighbors.add(mp.get(n)); // if a node reappears add it's corresponding cloneNode
            }
        }
        return currCloneNode;
    }
}
