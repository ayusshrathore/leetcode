class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        // a + b + c = 0;
        // b + c = -a;
        for (int i = 0; i < nums.length - 2; i++) {
            
          // Check if a does not have duplicate
          if (i == 0 || nums[i] != nums[i - 1]) {
            int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
              
            while (low < high) {
              if (nums[low] + nums[high] == sum) {
                list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                
                // Ignoring all low and high duplicates
                while (low < high && nums[low] == nums[low + 1])
                  low++;
                while (low < high && nums[high] == nums[high - 1])
                  high--;
                  
                low++;
                high--;
              } else if (nums[low] + nums[high] < sum)
                low++;
              else
                high--;
            }
          }
        }
        return list;
    }
}