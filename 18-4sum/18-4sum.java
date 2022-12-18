class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
          long target_1 = target - nums[i];
          for (int j = i + 1; j < nums.length; j++) {
            long target_2 = target_1 - (long)nums[j];
            int front = j + 1;
            int back = nums.length - 1;
            while (front < back) {
              long sum = nums[front] + nums[back];
              if (sum < target_2)
                front++;
              else if (sum > target_2)
                back--;
              else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(nums[front]);
                temp.add(nums[back]);
                if (!result.contains(temp))
                    result.add(temp);

                while (front < back && nums[front] == temp.get(2))
                  front++;
                while (front < back && nums[back] == temp.get(3))
                  back--;
              }
            }
            if (j + 1 != nums.length && nums[j + 1] == nums[j])
              j++;
          }
          if (i + 1 != nums.length && nums[i + 1] == nums[i])
            i++;
        }
        return result;
    }
}