class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> adj = new HashMap<>();
        double[] result = new double[n];
        
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            double prob = succProb[i];
            
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(new Pair<>(v, prob));
            adj.get(v).add(new Pair<>(u, prob));
        } // build adj
        
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey())); //MaxHeap 

        result[start] = 1; // probablity to reach start from start (100%)
        pq.add(new Pair<Double, Integer>(1.0, start));
        
        while(!pq.isEmpty()) {
            
            int currNode = pq.peek().getValue();
            double currProb = pq.peek().getKey();
            pq.poll();
                
            if(!adj.containsKey(currNode))
                break;
            
            for(Pair<Integer, Double> p : adj.get(currNode)) {
                double adjProb = p.getValue();
                int adjNode = p.getKey();
                
                if(result[adjNode] < currProb * adjProb) {
                    
                    result[adjNode] = currProb * adjProb;
                    pq.add(new Pair(result[adjNode], adjNode));
                }
            }
        }
        
        return result[end];
    }
}