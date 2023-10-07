class Solution {
     public int[] shuffle(int[] nums, int n){
         int[] resultNums = new int[2*n];
         for(int i=0;i<2*n;i++)
        {
            resultNums[i] = (i%2==0) ? nums[i/2] : nums[n + i/2];
         }
        return resultNums;
        
    }
}