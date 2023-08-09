class Solution { // Greedy + Binary Search O(n * log(n))
    private int n;
    
    public int minimizeMax(int[] nums, int p) {
        this.n = nums.length;
        Arrays.sort(nums);
        
        int low = 0, high = nums[n-1]- nums[0];
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
        
            if(countPairs(nums, mid) >= p)
                high = mid - 1;
            
            else low = mid + 1;
        }
        
        return low;
    }
    
    private int countPairs(int[] nums, int target) {
        int count = 0;
            
        int i = 0;
        while(i < n - 1) {
            int diff = nums[i + 1] - nums[i];
            
            if(diff <= target) { 
                count++;
                i+=2;     // taken this diff into consideration
            }
            
            else i++; // skipped this diff
        }
        
        return count;
    }
}