class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return root;
        }
        if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else if (key < root.val){
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null){
                return root.right;
            } else {
                TreeNode tmp = root.left;
                while (tmp.right != null){
                    tmp = tmp.right;
                }
                root.val = tmp.val;
                root.left = deleteNode(root.left, tmp.val);
            }
        }
        return root;
    }
}
