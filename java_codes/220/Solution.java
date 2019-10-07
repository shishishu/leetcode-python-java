import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        int i = 0;
        TreeSet<Long> values = new TreeSet<>();
        while (i < nums.length){
            Long floor = values.floor((long) nums[i]);
            Long ceil = values.ceiling((long) nums[i]);
            if ((floor != null && nums[i] - floor <= t) || (ceil != null && ceil - nums[i] <= t)) {
                return true;
            }
            values.add((long) nums[i++]);
            if (i > k) {
                values.remove((long) nums[i - k - 1]);
            }
        }
        return false;
    }
}
