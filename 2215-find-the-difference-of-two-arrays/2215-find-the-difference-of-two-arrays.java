class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> st1 = new HashSet<>();
        Set<Integer> st2 = new HashSet<>();
        Set<Integer> st3 = new HashSet<>();
        
        for(int i = 0; i < n; i++)
            st1.add(nums1[i]);
        
        for(int i = 0; i < m; i++){
            st3.add(nums2[i]);
            st2.add(nums2[i]);
        }
        
        st2.removeAll(st1);
        st1.removeAll(st3);
        
        List<Integer> l1 = new ArrayList<>(st1);
        List<Integer> l2 = new ArrayList<>(st2);
                
        res.add(l1);
        res.add(l2);
        
        return res;
            
    }
}