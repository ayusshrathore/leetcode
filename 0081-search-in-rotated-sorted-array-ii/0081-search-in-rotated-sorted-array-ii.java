class Solution { // BinarySearch, TC: O(n)
    public boolean search(int[] nums, int target) {        
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            // Handling duplicates on both sides
            while (left < mid && nums[left] == nums[mid]) {
                left++;
            }
            while (mid < right && nums[mid] == nums[right]) {
                right--;
            }
            
            if (nums[left] <= nums[mid]) {  // If the left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            else { // If the right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return false;
    }
}