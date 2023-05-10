class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        
        int n = nums.length, left = 0, right = n-1;
        int mod = (int)1e9 + 7, noOfSubseq = 0;
        
        int[] power = new int[n];
        power[0] = 1;
        
        for(int i = 1; i < n; i++) 
            power[i] = ((power[i-1] * 2) % mod);
        
        while(left <= right) {
            if(nums[left] + nums[right] <= target) {
               noOfSubseq = noOfSubseq % mod + power[right - left] % mod;
                left++;
            }
            else{
                right--;
            }
            
        }
        
        return noOfSubseq;
    }
}