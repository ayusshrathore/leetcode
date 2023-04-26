class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1)
            return stones[0];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        
        for(int st : stones)
            pq.add(st);
        
        while(pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            
            if(first != second) {
                first = first - second;
                pq.add(first);    
            }
            
        }
        
        if(!pq.isEmpty())
            return pq.poll();
        
        return 0;
    }
}