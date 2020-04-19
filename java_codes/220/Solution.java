import java.util.HashMap;
import java.util.Map;
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

// bucket sorting
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; i++){
            long m = getID(nums[i], w);
            if (d.containsKey(m)){
                return true;
            }
            if (d.containsKey(m-1) && Math.abs(d.get(m-1) - nums[i]) <= t){
                return true;
            }
            if (d.containsKey(m+1) && Math.abs(d.get(m+1) - nums[i]) <= t){
                return true;
            }
            d.put(m, (long)nums[i]);
            if (i >= k){
                d.remove(getID(nums[i-k], w));
            }
        }
        return false;
    }

    private long getID(long i, long w){
        return i < 0 ? (i + 1) / w - 1: i / w;
    }
}