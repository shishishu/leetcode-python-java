public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // dp[i] means the maximum subarray ending with nums[i]
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxVal = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }
}
