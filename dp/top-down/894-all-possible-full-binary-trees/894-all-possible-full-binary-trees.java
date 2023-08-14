/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        return solve(n, new HashMap<>());
    }
    public List<TreeNode> solve(int n, Map<Integer, List<TreeNode>> dp) {
        if(n % 2 == 0) return new ArrayList<TreeNode>(); // empty list, since FBT not possible with event number of nodes
        
        if(n == 1) {
            List<TreeNode> lst = new ArrayList<>();
            lst.add(new TreeNode(0, null, null));
            return lst;
        }
        
        if(dp.containsKey(n))
            return dp.get(n);
        
        List<TreeNode> result = new ArrayList<>();
        
        for(int i = 1; i < n; i+=2) { // skipping the even numbers till n
            List<TreeNode> lhs = solve(i, dp);
            List<TreeNode> rhs = solve(n-i-1, dp); // getting the nodes to the right
            
            for(TreeNode leftNode : lhs) {
                for(TreeNode rightNode : rhs) {
                    TreeNode root = new TreeNode(0, null, null);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        
        dp.put(n, result);
        return result;
    }
}