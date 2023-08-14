class Solution { // Sliding window
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> lst = new ArrayList<>();
        
        int i = 0;
        
        while(i < n) {
            int start = nums[i];
            while(i + 1 < n && nums[i] + 1 == nums[i+1]) // while the difference is 1
                i++;
            
            if(start == nums[i])
                lst.add(String.valueOf(nums[i])); // 'a', since a == b
            
            else {
                lst.add(String.valueOf(start) + "->" + String.valueOf(nums[i])); // 'a->b', since a != b 
            }
            
            i++;
        }
        
        return lst;
    }
}