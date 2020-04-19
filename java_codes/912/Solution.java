class Solution {
    public int[] sortArray(int[] nums) {
        int shiftVar = 50000;
        int[] interArray = new int[50000*2+1];
        int idx = 0;
        for (int num: nums){
            interArray[num + shiftVar]++;
        }
        for (int i = 0; i < interArray.length; i++){
            while(interArray[i]-- > 0){
                nums[idx++] = i - shiftVar;
            }
        }
        return nums;
    }
}
