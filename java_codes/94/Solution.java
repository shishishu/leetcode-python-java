import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (true){
            goAlongLeftBranch(root, stack);
            if (stack.isEmpty()){
                break;
            }
            root = stack.pop();
            output.add(root.val);
            root = root.right;
        }
        return output;
    }

    public void goAlongLeftBranch(TreeNode root, Stack<TreeNode> stack){
        while(root != null){
            stack.add(root);
            root = root.left;
        }
    }
}
