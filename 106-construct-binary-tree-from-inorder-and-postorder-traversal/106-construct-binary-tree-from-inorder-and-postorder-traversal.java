class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++)
            mp.put(inorder[i], i);
        
        return buildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, mp);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> mp) {
        if(inStart > inEnd) return null; // base case
        
        TreeNode root = new TreeNode(postorder[postEnd]); // postorder -> [left, right, root]
        
        int i = mp.get(root.val); // find this root in inorder array, then calculate no. of nodes in left & right
        
        int leftSize = i-inStart; // no. of nodes in left sub tree
        int rightSize = inEnd-i; // no. of nodes in right sub tree
            
        root.left = buildTree(inorder, postorder, inStart, i-1, postStart, postStart+leftSize-1, mp);
        root.right = buildTree(inorder, postorder, i+1, inEnd, postEnd-rightSize, postEnd-1, mp);
        
        return root;
    }
}
