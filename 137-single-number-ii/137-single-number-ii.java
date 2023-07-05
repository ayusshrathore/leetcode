class Solution { // Bit Manipulation
    public int singleNumber(int[] nums) {
        
        int result = 0;
        
        for(int k = 0; k <= 31; k++) {
            
            int cntOnes = 0;
            int tmp = 1 << k;
            
            for(int n : nums) {
                
                if((n & tmp) != 0)  // counting no. of 1's for each bit
                    cntOnes++;
                
            }
            
            if(cntOnes % 3 == 1) { // if no. of 1's are even then resultant kth bit will also be 1
                result = result | (tmp);
            }
        }
        
        return result;
    }
}