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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);

    }
    private boolean isSym(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L != null && R != null && L.val == R.val) {
            return isSym(L.left, R.right) && isSym(L.right, R.left);
        }
        return false;
    }
}