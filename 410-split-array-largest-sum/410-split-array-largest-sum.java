class Solution {
    public int splitArray(int[] nums, int m) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i : nums) {
            low = Math.max(low, i);
            high += i;
        }
        int res = high;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canSplit(nums, mid, m)) {
                res = Math.min(res, mid);
                high = mid - 1;
            } else low = mid + 1;
        }
        return res;
    }
    
    private boolean canSplit(int[] nums, int mid, int m) {
        int count = 1, sum = 0;
        for (int n : nums) {
            sum += n;
            if (sum > mid) {
                count++;
                sum = n;
            }
        }
        return count <= m;
    }
}