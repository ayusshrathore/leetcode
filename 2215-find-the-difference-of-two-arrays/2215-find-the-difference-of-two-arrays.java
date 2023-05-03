class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        
        for (int num : nums1)
            s1.add(num);
        
        for (int num : nums2)
            s2.add(num);
        
        List<Integer> l1 = new ArrayList<>(s1);
        l1.removeAll(s2);
        
        List<Integer> l2 = new ArrayList<>(s2);
        l2.removeAll(s1);
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(l1);
        result.add(l2);
        
        return result;
    }
}