import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

// Iterative
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            int complement = k - node.val;
            if (set.contains(complement)){
                return true;
            }
            set.add(node.val);
            if (node.left != null){
                stack.add(node.left);
            }
            if (node.right != null){
                stack.add(node.right);
            }
        }
        return false;
    }
}

// HashSet
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}