class Solution {
    /*
        DP, TOP-DOWN, TC: O( n * nth catalan number) -> Traversing n nodes and (creating m no. of binary search trees)
        where m = nth catalan number
    */
    
    public List<TreeNode> generateTrees(int n) {
        Map<Map.Entry<Integer, Integer>, List<TreeNode>> dp = new HashMap<>();
        return solve(1, n, dp);
    }
    
    private List<TreeNode> solve(int start, int end, Map<Map.Entry<Integer, Integer>, List<TreeNode>> dp) {
        List<TreeNode> res = new ArrayList<>();
        Map.Entry<Integer, Integer> key = Map.entry(start, end);
        
        if (start > end) { // not possible to create trees any further;
            res.add(null);
            dp.put(key, res);
            return res;
        } 
            
        if (dp.containsKey(key))
            return dp.get(key);
        
        for (int i = start; i <= end; i++) { // make each and every node between start and end as root node recursively
            
            List<TreeNode> leftBSTrees = solve(start, i - 1, dp);
            List<TreeNode> rightBSTrees = solve(i + 1, end, dp);
            
            for (TreeNode leftNode : leftBSTrees) {
                for (TreeNode rightNode : rightBSTrees) {
                    
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    
                    res.add(root);
                }
            }
        }
        
        dp.put(key, res);
        return res;
    }
}
