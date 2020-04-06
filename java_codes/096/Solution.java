// DP
class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        for (int i=2; i <= n; i++){
            for (int j=1; j<=i; j++){
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}

// Recursive
class Solution {
    public int numTrees(int n) {
        return subTrees(1, n);
    }
    public int subTrees(int lo, int hi){
        if (lo >= hi){
            return 1;
        }
        int total = 0;
        for (int i=lo; i<=hi; i++){
            total += subTrees(lo, i - 1) * subTrees(i + 1, hi);
        }
        return total;
    }
}