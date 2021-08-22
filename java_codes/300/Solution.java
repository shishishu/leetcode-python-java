class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null){
            return 0;
        }
        int len_nums = nums.length;
        int[] mem = new int[len_nums];
        int result = 1;
        for (int i = 0; i < len_nums; i++){
            mem[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    mem[i] = Math.max(mem[j] + 1, mem[i]);
                }
            }
            result = Math.max(result, mem[i]);
        }
        return result;
    }
}
