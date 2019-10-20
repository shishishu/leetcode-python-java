import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

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
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

// BFS
class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            depth += 1;
        }
        return depth;
    }
}

// DFS
class Solution3 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int depth = 0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            int tmp = value.pop();
            depth = Math.max(tmp, depth);
            if(node.left != null){
                stack.push(node.left);
                value.push(tmp + 1);
            }
            if(node.right != null){
                stack.push(node.right);
                value.push(tmp + 1);
            }
        }
        return depth;
    }
}
