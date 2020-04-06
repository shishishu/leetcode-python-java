import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

// Recursive
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root != null){
            TreeNode rightNode = invertTree(root.right);
            TreeNode leftNode = invertTree(root.left);
            root.right = leftNode;
            root.left = rightNode;
        }
        return root;
    }
}

// Iterative
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if (curr != null){
                TreeNode tmp = curr.right;
                curr.right = curr.left;
                curr.left = tmp;
                stack.add(curr.left);
                stack.add(curr.right);
            }
        }
        return root;
    }
}