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
    private int maxResult = 0;
    
    public int longestZigZag(TreeNode root) {
        solve(root, 0, false);
        solve(root, 0, true);
        
        return maxResult;
    }
    public void solve(TreeNode root, int steps, Boolean goLeft) {
        if(root == null)
            return;
        
        maxResult = Math.max(maxResult, steps);
        
        if(goLeft) {
            solve(root.left, steps+1, false); // since going left, for the next time goLeft = false
            solve(root.right, 1, true);
        }
        
        else {
            solve(root.right, steps+1, true);
            solve(root.left, 1, false);
        }
    }
}