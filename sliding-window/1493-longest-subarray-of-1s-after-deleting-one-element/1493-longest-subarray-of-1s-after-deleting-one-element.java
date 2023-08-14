class Solution { // Sliding Window optimized O(n)
    public int longestSubarray(int[] nums) {
        int n = nums.length, i = 0, j = 0, lastZeroIdx = -1, result = 0;
        
        while(j < n) {
            
            if(nums[j] == 0) {
                i = lastZeroIdx + 1;
                lastZeroIdx = j;
            }
            
            result = Math.max(result, (j - i));
            j++;
        }
        
        return result;
    }
}