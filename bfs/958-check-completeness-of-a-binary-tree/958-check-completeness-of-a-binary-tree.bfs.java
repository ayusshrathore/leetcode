class Solution {
    public boolean isCompleteTree(TreeNode root) { // BFS
        Queue<TreeNode> q = new LinkedList<>();
        Boolean nullNodeFound = false; // to track if we have seen any null values till now
        
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            
            if(node == null){
                nullNodeFound = true; // null value seen
            } else {
                if(nullNodeFound) return false; // if we have seen null value in the past & still we end up at the node gotcha this isn't a complete binary tree
                
                q.offer(node.left);                
                q.offer(node.right);
            }
        }
        return true;
    }
}
