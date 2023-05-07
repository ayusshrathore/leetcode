class Solution {
    public int numSubseq(int[] nums, int target) {        
        int n = nums.length, left = 0, right = n-1;
        int mod = (int)1e9 + 7, noOfSubseq = 0;
        
        Arrays.sort(nums); // so that we can determine when to stop when curr sum gets over target

        int[] power = new int[n];
        power[0] = 1;
        
        for(int i = 1; i < n; i++) // precompute the power since Math.pow is an expensive operation to perform
            power[i] = ((power[i-1] * 2) % mod); // [1, 1*2, 2*2, .... power[n-1]*2]
        
        /* [3, 5, 6, 7], target = 9, (3+6) <= 9 -> while taking 3 in course we have further 2 number to deal with and then we have further 2 options each (whether to                        include 5 or not, and same goes with 6) so 4 options, 2(right) - 0(left), 2 ^ (right - left) since for every idx we have 2 options to deal with
        */
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