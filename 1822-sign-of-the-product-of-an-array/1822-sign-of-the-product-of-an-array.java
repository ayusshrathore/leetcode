class Solution {
    public int arraySign(int[] nums) {
        int n = nums.length, product = 1;
        
        for(int i = 0; i < n; i++) {
            if(nums[i] == 0)
                return 0;
            
            else if(nums[i] < 0) 
                product *= -1;
            
            else
                product *= 1;
        }
        
        return product;
    }
}