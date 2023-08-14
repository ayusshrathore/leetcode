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
class Solution { // DFS
    
    private int lvl = 0;
    public int[] sums = new int[10001];
    
    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);
        
        int ans = 0;
        int sum = sums[0];
        
        for(int i = 1; i < lvl; i++) {
            if(sums[i] > sum) {
                sum = sums[i];
                ans = i;
            }
        }
        
        return ans + 1; // since it's zero based indexing
    }
    private void dfs(TreeNode root, int level) {
        lvl = Math.max(lvl, level);
        
        if(root == null)
            return;
        
        sums[level] += root.val; // root
        
        dfs(root.left, level+1); // left
        dfs(root.right, level+1); // right
    }
}