import java.util.Map.Entry;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k) return nums;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i: nums)
            map.put(i, map.getOrDefault(i,0)+1);
        
        Queue<Integer> q = new PriorityQueue<>(k, (a,b) -> map.get(a) - map.get(b));

        for(int i: map.keySet()){
            q.add(i);
            if (q.size() > k) q.poll();
        }
        
        return q.stream().mapToInt(Integer::valueOf).toArray();
    }
}