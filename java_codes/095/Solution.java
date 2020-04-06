import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

// DP
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new List[n+1];
        res[0] = new ArrayList<TreeNode>();
        if (n == 0){
            return res[0];
        }
        res[0].add(null);
        res[1] = new ArrayList<TreeNode>();
        res[1].add(new TreeNode(1));
        for (int i=2; i <=n ; i++){
            res[i] = new ArrayList<TreeNode>();
            for (int j=1; j<=i; j++){
                for (TreeNode nodeL: res[j - 1]){
                    for (TreeNode nodeR: res[i - j]){
                        TreeNode node = new TreeNode(j);
                        node.left = nodeL;
                        node.right = cloneTrees(nodeR, j);
                        res[i].add(node);
                    }
                }
            }
        }
        return res[n];
    }

    public TreeNode cloneTrees(TreeNode node, int offset){
        if (node == null){
            return null;
        }
        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = cloneTrees(node.left, offset);
        newNode.right = cloneTrees(node.right, offset);
        return newNode;
    }
}

// Recursive
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return (n == 0)?new ArrayList<TreeNode>(): geneTrees(1, n);
    }

    public TreeNode formatNode(int val, TreeNode left, TreeNode right){
        TreeNode newNode = new TreeNode(val);
        newNode.left = left;
        newNode.right = right;
        return newNode;
    }

    public List<TreeNode> geneTrees(int lo, int hi){
        List<TreeNode> res = new ArrayList<TreeNode>();
        for (int i=lo; i<=hi; i++){
            for(TreeNode nodeL: geneTrees(lo, i - 1)){
                for (TreeNode nodeR: geneTrees(i + 1, hi)){
                    res.add(formatNode(i, nodeL, nodeR));
                }
            }
        }
        if (res.isEmpty()){
            res.add(null);
        }
        return res;
    }
}