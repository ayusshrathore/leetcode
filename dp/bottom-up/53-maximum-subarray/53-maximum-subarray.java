class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int currMax = 0;

        for(int num : nums){
            if(currMax < 0) currMax = 0; // as -ve will only lead to min ans
            currMax += num;

            maxSoFar = Math.max(maxSoFar, currMax);            
        }
        return maxSoFar;
    }
}