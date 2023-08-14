class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (rem < 0) rem += k;
            if (map.containsKey(rem)) count += map.get(rem);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        
        return count;
    }
}

// Brute Force:
// int count = 0, n = nums.length, sum = 0;
// for (int i = 1; i < n; i++) nums[i] += nums[i - 1]; 
// for (int i = 0; i < n; i++) {
//     for (int j = i; j < n; j++) {
//         sum = (i == 0) ? nums[j] : nums[j] - nums[i - 1]; 
//         if (sum % k == 0) count++;
//     }
// }
// return count;