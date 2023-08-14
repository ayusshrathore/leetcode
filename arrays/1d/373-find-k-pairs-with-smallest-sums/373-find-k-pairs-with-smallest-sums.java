class Solution { // BruteOptimal O(n * m * log(k))
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        PriorityQueue<Pair<Integer, Pair<Integer,Integer>>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey()); // MaxHeap
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int sum = nums1[i] + nums2[j]; // each pair
                
                if(pq.size() < k) {
                    pq.add(new Pair(sum, new Pair(nums1[i], nums2[j])));
                }
                else if(pq.peek().getKey() > sum) {
                    pq.poll();
                    pq.add(new Pair(sum, new Pair<>(nums1[i], nums2[j])));
                } 
                else {
                    break;
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> p = pq.poll();
            
            int i = p.getValue().getKey();
            int j = p.getValue().getValue();
            
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            tmp.add(j);
            
            res.add(tmp);
        }
        
        return res;
    }
}