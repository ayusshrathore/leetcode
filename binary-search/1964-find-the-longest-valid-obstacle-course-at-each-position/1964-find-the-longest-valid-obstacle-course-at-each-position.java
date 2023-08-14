class Solution { // LIS
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        
        int[] res = new int[n];
        
        List<Integer> dp = new ArrayList<>(); // dp[i] = x, denotes that length of lis is (i+1) with ending digit = x;
        
        for(int i = 0; i < n; i++) {
            int idx = upperBound(dp, obstacles[i]);
            
            if(idx == dp.size()) 
                dp.add(obstacles[i]);
            
            else 
                dp.set(idx, obstacles[i]);
            
            res[i] = idx + 1;
        }
        
        return res;
    }
    public int upperBound(List<Integer> dp, int target) {
        int low = 0; int high = dp.size();
        
        while(low < high) {
            int mid = (low + high) >>> 1;
            
            if(dp.get(mid) <= target)
                low = mid + 1;
            
            else 
                high = mid;
            
        }
        
        return low;
    }
}