/*

1. When n = 0, there is only one unique BST, an empty tree.
n = 0
Result = 1

2. When n = 1, there is only one unique BST with one node.
n = 1
   1
Result = 1

3. When n = 2, there are two unique BSTs with two nodes.
n = 2
   1       2
    \     /
     2   1
Result = 2

4. When n = 3, there are five unique BSTs with three nodes.
n = 3
   1       1       2       3       3
    \       \     / \     /       /
     2       3   1   3   1       2
      \              /     \     /
       3            2       1   1
                               \
                                2
Result = 5

The pattern for calculating the number of unique BSTs is clear: the number of unique BSTs for n nodes can be obtained by summing the products of the number of unique BSTs for all possible left and right subtrees, where the left subtree has i nodes, and the right subtree has n-i-1 nodes.
*/
class Solution { // TOP-DOWN, TC: O(n * m), where m = nth Catalan number
    public int numTrees(int n) {
        return solve(n);
    }
    private int solve(int n) {
        if(n <= 1)
            return 1;
        
        int nthCatalan = 0;
        for(int i = 0; i < n; i++) {
            nthCatalan += solve(i) * solve(n-i-1);
        }
        
        return nthCatalan;
    }
}