class Solution {
    public int findNumbers(int[] nums) {
        
        int count,even;
        even=0;
        
        for(int element: nums)
        {
            count =0;
            while(element !=0)
            {
                element /=10;
                count++;
            }
            if(count %2 ==0){even++;}
            
        }
        return even;
        
    }
}