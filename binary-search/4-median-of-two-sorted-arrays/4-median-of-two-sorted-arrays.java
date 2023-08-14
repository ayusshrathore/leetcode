class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, result, 0, nums1.length);  
        System.arraycopy(nums2, 0, result, nums1.length, nums2.length);  

        double median = 0;
        int mid = result.length/2;
        if (result.length % 2 == 0) {
            median = (double) (result[mid-1] + result[mid]) / 2;
        } else {
            median = (double) result[mid];
        }
        return median;
    }
}