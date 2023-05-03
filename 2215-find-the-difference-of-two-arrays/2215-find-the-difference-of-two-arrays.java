class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> st1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> st2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        
        Set<Integer> st3 = new HashSet<>();
        st3.addAll(st2);
        
        st2.removeAll(st1);
        st1.removeAll(st3);
        
        List<Integer> l1 = new ArrayList<>(st1);
        List<Integer> l2 = new ArrayList<>(st2);
                
        res.add(l1);
        res.add(l2);
        
        return res;
            
    }
}