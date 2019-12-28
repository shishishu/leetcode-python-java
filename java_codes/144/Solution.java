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

// method 1: Recursive
class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        recurPreOrder(root, output);
        return output;
    }

    public void recurPreOrder(TreeNode root, List<Integer> output){
        if (root != null){
            output.add(root.val);
            recurPreOrder(root.left, output);
            recurPreOrder(root.right, output);
        }
    }
}

// method 2: iterative with stack
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root != null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            TreeNode x = stack.pop();
            output.add(x.val);
            if (x.right != null){
                stack.push(x.right);
            }
            if (x.left != null){
                stack.push(x.left);
            }
        }
        return output;
    }
}

// method 3: iterative (general)
class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (true){
            visitAlongLeftBranch(root, output, stack);
            if (stack.isEmpty()){
                break;
            }
            root = stack.pop();
        }
        return output;
    }

    public void visitAlongLeftBranch(TreeNode root, List<Integer> output, Stack<TreeNode> stack){
        while (root != null){
            output.add(root.val);
            stack.add(root.right);
            root = root.left;
        }
    }
}