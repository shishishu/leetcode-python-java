// binary search
class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int middle;
        while (low <= high){
            middle = (low + high) / 2;
            if (nums[middle] == target){
                return middle;
            } else if (nums[middle] < target){
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return low;
    }
}