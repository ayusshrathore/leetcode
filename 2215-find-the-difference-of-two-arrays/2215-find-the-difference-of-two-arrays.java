class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> l1 = getDifference(nums1, nums2);
        List<Integer> l2 = getDifference(nums2, nums1);
        
        return Arrays.asList(l1, l2);
    }
    private List<Integer> getDifference(int[] nums1, int[] nums2) {
        List<Integer> difference = new ArrayList<>();
        boolean[] seen = new boolean[2001];

        for (int i : nums2) 
            seen[i + 1000] = true;

        for (int i : nums1) 
            if (!seen[i + 1000]) {
                seen[i + 1000] = true;
                difference.add(i);
            }
        
        
        return difference;
    }
}