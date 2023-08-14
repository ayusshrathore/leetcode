class Solution {
    public int minimizeArrayValue(int[] nums) {
        int min = 0, max = 0, n = nums.length;
        
        for(int i = 0; i < n; i++) 
            max = Math.max(max, nums[i]);
        
        while(min <= max) {
            int mid = (min + max) >>> 1;
            
            if(isValid(mid, nums, n)) // if we found the new max search towards the left
                max = mid - 1;
            
            else min = mid + 1;
        }
        
        return min;
    }
    public boolean isValid(int mid, int[] nums, int n) {
        if(nums[0] > mid) // we can't decrease this value
            return false;
        
        long prev = nums[0];
        
        for(int i = 1; i < n; i++) {
            long buffer = mid - prev;
            
            if(nums[i] - buffer > mid)
                return false;
            
            prev = nums[i] - buffer;
        }
        
        return true;
    }
}