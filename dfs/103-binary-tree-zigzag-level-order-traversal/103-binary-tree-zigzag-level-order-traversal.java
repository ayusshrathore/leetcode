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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) return;

        if (level == res.size()) 
            res.add(new ArrayList<>());

        if (level % 2 == 0) res.get(level).add(node.val);
        else res.get(level).add(0, node.val); // add node at front
        
        dfs(node.left, res, level + 1);
        dfs(node.right, res, level + 1);
    }
}