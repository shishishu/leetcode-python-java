import java.util.ArrayList;
import java.util.regex.Matcher;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

// inorder traverse
class Solution {

    private ArrayList<Integer> interNumbers = new ArrayList<Integer>();
    private long minDiff = Long.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        for (int i = 0; i < interNumbers.size() - 1; i++){
            minDiff = Math.min(minDiff, interNumbers.get(i + 1) - interNumbers.get(i));
        }
        return (int) minDiff;
    }

    public void inOrder(TreeNode root){
        if (root.left != null){
            inOrder(root.left);
        }
        interNumbers.add(root.val);
        if (root.right != null){
            inOrder(root.right);
        }
    }
}

// recursive
class Solution {

    private long minDiff = Long.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return (int) minDiff;
    }

    private void helper(TreeNode curr, long lb, long rb){
        if (curr == null){
            return;
        }
        if (lb != Long.MIN_VALUE){
            minDiff = Math.min(minDiff, curr.val - lb);
        }
        if (rb != Long.MAX_VALUE){
            minDiff = Math.min(minDiff, rb - curr.val);
        }
        helper(curr.left, lb, curr.val);
        helper(curr.right, curr.val, rb);
    }
}