class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0, s, res, path);
        return res;
    }
    
    private void func(int idx, String s, List<List<String>> res, List<String> path) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
               if (isPalindrome(s, idx, i)) {
                   path.add(s.substring(idx, i + 1));
                   func(i + 1, s, res, path);
                   path.remove(path.size() - 1);
               } 
        }
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) 
            if (s.charAt(start++) != s.charAt(end--)) 
                return false;
        return true;
    }
}