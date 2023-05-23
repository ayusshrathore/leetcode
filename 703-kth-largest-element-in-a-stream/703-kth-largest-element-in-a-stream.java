class KthLargest {
    int K;
    PriorityQueue<Integer> pq;
    
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>((a, b) -> a - b);
        
        for(int num : nums)
            pq.add(num);
        
        System.out.println(pq);
        K = k;
    }
    
    public int add(int val) {
        pq.add(val);
        
        while(pq.size() > K)
            pq.poll();
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */