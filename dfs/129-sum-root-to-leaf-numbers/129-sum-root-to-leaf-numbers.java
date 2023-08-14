class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    public int sumNumbers(TreeNode root, int res) {
        if(root == null) return 0;
        
        res = (res * 10) + root.val; // res = 1, 10 * 2 -> 12
        
        if(root.left == null && root.right == null)
            return res;
        
        int left = sumNumbers(root.left, res);
        int right = sumNumbers(root.right, res);
        
        return left + right;
    }
}
