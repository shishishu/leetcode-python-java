import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        recurPostOrder(root, output);
        return output;

    }

    public void recurPostOrder(TreeNode root, List<Integer> output){
        if (root != null){
            recurPostOrder(root.left, output);
            recurPostOrder(root.right, output);
            output.add(root.val);
        }
    }
}

// method 2
class Solution2 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        Stack stack = new Stack();
        stack.push(Arrays.asList(root, false));
        while (!stack.isEmpty()){
            List tmp = (List) stack.pop();
            TreeNode curNode = (TreeNode) tmp.get(0);
            boolean visited = (boolean) tmp.get(1);
            if (curNode != null){
                if (visited){
                    output.add(curNode.val);
                } else {
                    stack.add(Arrays.asList(curNode, true));
                    stack.add(Arrays.asList(curNode.right, false));
                    stack.add(Arrays.asList(curNode.left, false));
                }
            }
        }
        return output;
    }
}