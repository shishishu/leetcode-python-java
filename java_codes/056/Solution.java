import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {
    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval: intervals){
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            } else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);

    }

    private static class IntervalComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            return Integer.compare(a[0], b[0]);
//            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }
}

// compacted
class Solution {
    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval: intervals){
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            } else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);

    }
}