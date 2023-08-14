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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        getMinimumDifference(root, res);
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < res.size() - 1; i++)
            min = Math.min(min, Math.abs(res.get(i)-res.get(i+1)));
        
        return min;
    }
    public void getMinimumDifference(TreeNode node, List<Integer> res){
        if(node == null) return;
        
        getMinimumDifference(node.left, res);
        res.add(node.val); // add elements to list in sorted manner (left -> root -> right [inorder traversal])
        getMinimumDifference(node.right, res);
    }
}