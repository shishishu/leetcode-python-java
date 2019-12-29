class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int res = 0;
    public int findTilt(TreeNode root) {
        recUnit(root);
        return res;
    }

    public int recUnit(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = recUnit(root.left);
        int right = recUnit(root.right);
        res += Math.abs(left - right);
        return root.val + left + right;
    }
}