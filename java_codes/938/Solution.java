import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

// Recursvie
class Solution {

    int ans;

    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    private void dfs(TreeNode node, int L, int R){
        if (node != null){
            if (node.val >= L && node.val <= R){
                ans += node.val;
            }
            if (node.val > L){
                dfs(node.left, L, R);
            }
            if (node.val < R){
                dfs(node.right, L, R);
            }
        }
    }
}

// iterative
class Solution {

    public int rangeSumBST(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
                if (node.val >= L && node.val <= R){
                    ans += node.val;
                }
                if (node.val > L){
                    stack.push(node.left);
                }
                if (node.val < R){
                    stack.push(node.right);
                }
            }
        }
        return ans;
    }

}