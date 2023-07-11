/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();

        inOrder(root);

        BFS(target, k, res);

        return res;
    }

    private void BFS(TreeNode target, int k, List<Integer> res) {
        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(target);

        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        
        while(!que.isEmpty()) {
            int n = que.size();
            if (k == 0) break;

            while(n-- > 0) {
                TreeNode curr = que.poll();

                // left node
                if (curr.left != null && !visited.contains(curr.left.val)) {
                    que.offer(curr.left);
                    visited.add(curr.left.val);
                }

                // right node
                if (curr.right != null && !visited.contains(curr.right.val)) {
                    que.offer(curr.right);
                    visited.add(curr.right.val);
                }

                // parent node
                if (map.containsKey(curr) && !visited.contains(map.get(curr).val)) {
                    que.offer(map.get(curr));
                    visited.add(map.get(curr).val);
                }
            }

            k--;
        }

        while(!que.isEmpty()) {
            res.add(que.poll().val);
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            map.put(root.left, root);
        }

        inOrder(root.left);

        if (root.right != null) {
            map.put(root.right, root);
        }

        inOrder(root.right);
    }
}