class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i = 0; i<inorder.length; i++)
            mp.put(inorder[i], i);
        
        return buildTree(preorder, inorder, 0, inorder.length-1, 0, preorder.length-1, mp);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd, Map<Integer, Integer> mp) {
        if(inStart > inEnd || preStart > preEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]); // preorder = [3,2,1,4,5], root-> 3 (root, left, right)
        
        int i = mp.get(root.val);
        
        int leftSize = i-inStart;
        int rightSize = inEnd-i;
        
        root.left = buildTree(preorder, inorder, inStart, i-1, preStart+1, preEnd-rightSize, mp);
        root.right = buildTree(preorder, inorder, i+1, inEnd, preStart+leftSize+1, preEnd, mp);
        
        return root;
    }
}
