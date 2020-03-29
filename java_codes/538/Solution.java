import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

// traverse
class Solution {

    int total = 0;
    public TreeNode convertBST(TreeNode root) {
        visit(root);
        return root;
    }

    public void visit(TreeNode root) {
        if (root != null){
            visit(root.right);
            root.val += total;
            total = root.val;
            visit(root.left);
        }
    }
}

// iterative
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int total = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null){
            while (node != null){
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            total += node.val;
            node.val = total;
            node = node.left;
        }
        return root;
    }
}