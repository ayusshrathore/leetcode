class Solution {
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);
        
        return dfs(root, 1, totalNodes);
    }
    public boolean dfs(TreeNode root, int idx, int totalNodes){
        if(root == null) return true;
        
        if(idx > totalNodes) // [1, 2, 3, 4, 5, , 7] -> totalNodes = 6 but idx = 7
            return false;
        
        return dfs(root.left, 2*idx, totalNodes) && dfs(root.right, (2*idx) +1, totalNodes); // leftchild idx = 2 * i, rightchild idx = 2 * i + 1
    }
    public int countNodes(TreeNode root){
        if(root == null)
            return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
