class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        int count=0;
        int start,next;
        
        for(int i=0;i<nums.length;i++){
            start = nums[i];
            
            for(int j=i+1;j<nums.length;j++){
                
                next=nums[j];
            
                if(start==next){
                count++;
                }
                
            }
        }
        return count;
    }
}